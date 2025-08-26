package com.example.Security.service;

import com.example.Security.modal.TwoFactorOTP;
import com.example.Security.modal.User;

public interface TwoFactorOtpService {
    TwoFactorOTP createTwoFactorOtp(User user, String otp, String jwt) throws Exception;
    TwoFactorOTP findByUser(Long userId) throws Exception;
    TwoFactorOTP findById(String id) throws Exception;
    boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOTP, String otp) throws Exception;
    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP) throws Exception;
}
