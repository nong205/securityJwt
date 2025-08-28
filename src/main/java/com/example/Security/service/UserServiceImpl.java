package com.example.Security.service;

import com.example.Security.domain.VerificationType;
import com.example.Security.modal.TwoFactorAuth;
import com.example.Security.modal.User;
import com.example.Security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private User user;

    @Override
    public User findUserProfileByJwt(String jwt) throws Exception {
        String email = jwt.substring(7);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found");
        }
        return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found");
        }
        return user;
    }

    @Override
    public User findUserById(Long UserId) throws Exception {
        Optional<User> user = userRepository.findById(UserId);
        if (user.isEmpty()){
            throw new Exception("User not found");
        } else {
            return user.get();
        }
    }

    @Override
    public User enableTwoFactorAuthentication(VerificationType verificationType, String sendTo, User user) {
        TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
        twoFactorAuth.setEnabled(true);
        twoFactorAuth.setSendTo(verificationType);
        user.setTwoFactorAuth(twoFactorAuth);
      return userRepository.save(user);

    }

    @Override
    public User updatePassword(User user, String newPassword) {
        user.setPassword(newPassword);
        return userRepository.save(user);
    }
}
