package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"USER\"")
public class User extends PersistentEntity {
    private String username;
    private String password;

    @Transient
//    @OneToMany
    private List<OutFlow> outFlows;

//    @OneToMany
    @Transient
    private List<InFlow> inFlows;

    @OneToMany
    private List<Category> categories;
}
