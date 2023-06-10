package com.llama.headlessCMS.dto;

import com.llama.headlessCMS.model.Role;
import com.llama.headlessCMS.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequestDTO {
    private String username;
    private String password;
    private Role role;

    public User toUser() {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setRole(this.role);
        return user;
    }
}
