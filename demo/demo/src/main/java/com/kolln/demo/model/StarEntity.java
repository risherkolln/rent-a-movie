package com.kolln.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stars")
public class StarEntity {
    @Id
    private Long id;
    private String name;
    private int rating;
}
