package com.rafael.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RegisterRequest {

    private String username;
    private String password;
    private Set<String> roles;

}
