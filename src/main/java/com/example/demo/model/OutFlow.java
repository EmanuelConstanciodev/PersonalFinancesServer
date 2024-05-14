package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity

public class OutFlow {
    @Id
    private Long id;

    private String description;
    @ManyToOne
    private Category category;
}
