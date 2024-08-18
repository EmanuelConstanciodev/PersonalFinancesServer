package com.example.demo.model;

import com.example.demo.model.bought.Category;
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
    private List<MoneyFlow> outFlows;

    @OneToMany
    private List<Category> categories;
}
