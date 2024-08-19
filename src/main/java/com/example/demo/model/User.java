package com.example.demo.model;

import com.example.demo.model.bought.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"USER\"")
public class User extends PersistentEntity {
    private String name;
    private String surname;
    private String email;
    @Column(nullable = false)
    private String password;
}
