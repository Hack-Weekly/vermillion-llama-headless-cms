import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
@RestController
@RequestMapping("/api/images")
public class ImageController {

    private static final String IMAGE_UPLOAD_DIR = "image_uploads/";

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Create the directory for storing images if it doesn't exist
            File uploadDir = new File(IMAGE_UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            // Save the uploaded image to the server
            String fileName = file.getOriginalFilename();
            assert fileName != null;
            Path filePath = Path.of(IMAGE_UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return ResponseEntity.ok("Image uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image.");
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getImages() {
        File uploadDir = new File(IMAGE_UPLOAD_DIR);
        String[] files = uploadDir.list();

        if (files != null && files.length > 0) {
            List<String> imageNames = new ArrayList<>();
            for (String fileName : files) {
                imageNames.add(fileName);
            }
            return ResponseEntity.ok(imageNames);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        try {
            Path imagePath = Path.of(IMAGE_UPLOAD_DIR + imageName);
            byte[] imageBytes = Files.readAllBytes(imagePath);
            return ResponseEntity.ok(imageBytes);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{imageName}")
    public ResponseEntity<String> deleteImage(@PathVariable String imageName) {
        try {
            Path imagePath = Path.of(IMAGE_UPLOAD_DIR + imageName);
            Files.deleteIfExists(imagePath);
            return ResponseEntity.ok("Image deleted successfully.");
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
