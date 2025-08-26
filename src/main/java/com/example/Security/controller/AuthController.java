package com.example.Security.controller;

import com.example.Security.config.JwtProvider;
import com.example.Security.modal.User;
import com.example.Security.repository.UserRepository;
import com.example.Security.response.AuthResponse;
import com.example.Security.service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CustomerUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody User user) throws Exception {

        User isExistingUser = userRepository.findByEmail(user.getEmail());
        if (isExistingUser != null) {
            throw new Exception("User with email " + user.getEmail() + " already exists.");
        }

        User newUser = new User();
        newUser.setFullName(user.getFullName());
        newUser.setTwoFactorAuth(user.getTwoFactorAuth());
        newUser.setRole(user.getRole());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
//        newUser.setPassword(passwordEncoder.encode(user.getPassword()));


        User savedUser = userRepository.save(newUser);

        Authentication auth = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = JwtProvider.generateToken(auth);

        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setStatus(true);
        res.setMessage("User registered successfully");

        System.out.println("FULL NAME: " + user.getFullName());


        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }

//login
    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> login(@RequestBody User user) throws Exception {
        String username = user.getEmail();
        String password = user.getPassword();

        Authentication auth = authentication(username,password);

        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = JwtProvider.generateToken(auth);

        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setStatus(true);
        res.setMessage("Login successfully");

        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }

    private Authentication authentication(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (userDetails == null){
            throw new BadCredentialsException("invalid username " );
        }
        if(!password.equals(userDetails.getPassword())){
            throw new BadCredentialsException("invalid password" );
        }
        return new UsernamePasswordAuthenticationToken(
                username,
                password,
                userDetails.getAuthorities()
        );
        }
    }



