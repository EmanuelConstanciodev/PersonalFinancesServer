package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Category extends PersistentEntity {
    @Column
    private String name;
    @Column
    private String description;
}
