package com.concesionario.entity;

import lombok.Data;

@Data
public class PasswordReset {
    private String token;
    private String newPassword;
}
