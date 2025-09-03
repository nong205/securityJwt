package com.example.Security.service;

import com.example.Security.domain.VerificationType;
import com.example.Security.modal.ForgotPasswordToken;
import com.example.Security.modal.User;

public interface ForgotPasswordService {

    ForgotPasswordToken createToken(
            User user,
            String id,
            String sendTo,
            String otp,
            VerificationType verificationType
            ) throws Exception;
    ForgotPasswordToken findById(String id) throws Exception;
    ForgotPasswordToken findByUser(Long userId) throws Exception;
    void deleteToken(ForgotPasswordToken token) throws Exception;
}
