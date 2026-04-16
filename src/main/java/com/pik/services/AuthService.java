package com.pik.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pik.database.entities.User;
import com.pik.database.repository.UserRepository;
import com.pik.dtos.LoginDTO;
import com.pik.dtos.LoginResponse;
import com.pik.dtos.RegisterDTO;
import com.pik.utils.JwtUtils;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    public LoginResponse login(LoginDTO loginDTO) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getLogin(), loginDTO.getPassword()));

        LoginResponse response = new LoginResponse();

        response.setToken(jwtUtils.generateToken(auth));
        response.setUsername(loginDTO.getLogin());

        return response;
    }

    public LoginResponse register(RegisterDTO registerDTO) {
        LoginResponse response = new LoginResponse();

        User newUser = new User();
        newUser.setUsername(registerDTO.getUsername());
        newUser.setPasswordHash(passwordEncoder.encode(registerDTO.getPassword()));
        newUser.setCanBlog(false);
        newUser.setRole("USER");

        userRepository.save(newUser);

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setLogin(registerDTO.getUsername());
        loginDTO.setPassword(registerDTO.getPassword());
        response = login(loginDTO);

        return response;
    }
}
