package com.example.demo.dto;

import com.example.demo.config.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
  private String firstName;
  private String lastName;

  @NotBlank(message = "El correo electrónico es obligatorio.")
  @Email(message = "El correo electrónico debe tener un formato válido.")
  private String email;

  @ValidPassword
  private String password;
}
