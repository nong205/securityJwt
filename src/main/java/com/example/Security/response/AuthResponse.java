package com.example.Security.response;

import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private boolean Status;
    private String message;
    private boolean isTwoFactorAuthEnabled;
    private String session;
}
