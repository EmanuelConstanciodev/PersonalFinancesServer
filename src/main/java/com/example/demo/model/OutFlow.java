package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "OUTFLOW")
public class OutFlow {
    private String description;
    private Category category;
}
