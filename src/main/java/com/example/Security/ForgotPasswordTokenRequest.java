package com.example.Security;

import com.example.Security.domain.VerificationType;
import lombok.Data;

@Data
public class ForgotPasswordTokenRequest {
    private String sendTo;
    private String otp;
    private VerificationType verificationType;
}
