package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends PersistentEntity {
    private String username;
    private String password;

    @OneToMany
    private List<OutFlow> outFlows;

    @OneToMany
    private List<InFlow> inFlows;

    @OneToMany
    private List<Category> categories;
}
