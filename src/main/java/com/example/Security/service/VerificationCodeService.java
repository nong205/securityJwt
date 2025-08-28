package com.example.Security.service;

import com.example.Security.domain.VerificationType;
import com.example.Security.modal.User;
import com.example.Security.modal.VerificationCode;

public interface VerificationCodeService {
   VerificationCode sendVerificationCode(User user, VerificationType verificationType) throws Exception;
   VerificationCode getVerificationCodeById(Long id) throws Exception;
   VerificationCode getVerificationCodeByUser(Long userId ) throws Exception;
    void deleteVerificationCodeById(VerificationCode verificationCode) throws Exception;
}
