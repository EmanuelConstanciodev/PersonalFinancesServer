package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class PersistentEntity {
    @Id
    @GeneratedValue
    private Long id;
}
