package com.example.demo.services;

import com.example.demo.config.JwtUtil;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.exceptions.EmailAlreadyInUseException;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private JwtUtil jwtUtil; // Si decides usar JWT para manejar las sesiones
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private PasswordEncoder passwordEncoder;

  public User obtainUserByEmail(String userEmail) {
    return userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("No hay usuario con el mail dado"));
  }


  public String login(LoginDTO loginDTO) {
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    loginDTO.getEmail(), loginDTO.getPassword())
    );
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    return jwtUtil.generateToken(userDetails);
  }

  public void register(UserDTO userDTO) {
    if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
      throw new EmailAlreadyInUseException(userDTO.getEmail());
    }

    User newUser = new User();
    newUser.setName(userDTO.getFirstName());
    newUser.setSurname(userDTO.getLastName());
    newUser.setEmail(userDTO.getEmail());
    newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));

    userRepository.save(newUser);
  }
}
