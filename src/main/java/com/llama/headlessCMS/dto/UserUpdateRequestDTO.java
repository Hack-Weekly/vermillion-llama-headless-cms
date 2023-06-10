package com.llama.headlessCMS.dto;

import com.llama.headlessCMS.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequestDTO {
    private String username;
    private String password;
    private Role role;
}

