package com.example.demo.controller;

import com.example.demo.config.JwtUtil;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.UserDTO;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtil jwtUtil; // Si decides usar JWT para manejar las sesiones

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
    if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo ya está en uso.");
    }

    User newUser = new User();
    newUser.setName(userDTO.getFirstName());
    newUser.setSurname(userDTO.getLastName());
    newUser.setEmail(userDTO.getEmail());
    newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));

    userRepository.save(newUser);
    return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente.");
  }

  @PostMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
    try {
      Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              loginDTO.getEmail(), loginDTO.getPassword())
      );

      // Generar token JWT si la autenticación es exitosa
      UserDetails userDetails = (UserDetails) authentication.getPrincipal();
      String jwt = jwtUtil.generateToken(userDetails);

      return ResponseEntity.ok(new LoginResponse(jwt));

    } catch (BadCredentialsException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas.");
    }
  }
}
