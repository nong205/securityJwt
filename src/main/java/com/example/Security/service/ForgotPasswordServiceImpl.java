package com.example.Security.service;

import com.example.Security.domain.VerificationType;
import com.example.Security.modal.ForgotPasswordToken;
import com.example.Security.modal.User;
import com.example.Security.repository.ForgotPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService{

    @Autowired
    private ForgotPasswordRepository forgotPasswordRepository;

    @Override
    public ForgotPasswordToken createToken(User user, String id, String sendTo, String otp, VerificationType verificationType) throws Exception {
       ForgotPasswordToken token = new ForgotPasswordToken();
         token.setUser(user);
        token.setSendTo(sendTo);
        token.setVerificationType(verificationType);
         token.setOtp(otp);
         token.setId(id);
        return forgotPasswordRepository.save(token);
    }

    @Override
    public ForgotPasswordToken findById(String id) throws Exception {
        Optional<ForgotPasswordToken> token = forgotPasswordRepository.findById(id);
        return token.orElse(null);
    }

    @Override
    public ForgotPasswordToken findByUser(Long userId) throws Exception {
        return forgotPasswordRepository.findByUserId(userId);
    }

    @Override
    public void deleteToken(ForgotPasswordToken token) throws Exception {
        forgotPasswordRepository.delete(token);
    }
}
