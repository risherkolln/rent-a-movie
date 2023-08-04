package com.kolln.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "writers")
public class WritersEntity {
    @Id
    private Long id;
    private String name;
}
