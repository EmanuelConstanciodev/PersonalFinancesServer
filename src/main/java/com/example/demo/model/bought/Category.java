package com.example.demo.model.bought;

import com.example.demo.model.PersistentEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CATEGORY")
public class Category extends PersistentEntity {
    private String name;
    private String description;
}
