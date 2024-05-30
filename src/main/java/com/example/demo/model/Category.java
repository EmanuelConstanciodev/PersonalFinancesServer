package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "CATEGORY")
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Category {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
}
