package com.kolln.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "directors")
public class DirectorEntity {
    @Id
    private Long id;
    private String name;
}
