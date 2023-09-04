package com.kolln.demo.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "genres")
public class GenreEntity {
    @Id
    private Long id;
    private String name;
}
