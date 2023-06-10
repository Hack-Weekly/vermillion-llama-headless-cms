package com.llama.headlessCMS.dto;

import com.llama.headlessCMS.model.Role;
import com.llama.headlessCMS.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequestDTO {
    private String id;
    private String password;
    private Role role;

    public User toUser() {
        User user = new User();
        user.setId(this.id);
        user.setPassword(this.password);
        user.setRole(this.role);
        return user;
    }
}

