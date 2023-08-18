package com.kolln.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "formats")
public class FormatEntity {
    @Id
    private Long id;
    private String name;
}
