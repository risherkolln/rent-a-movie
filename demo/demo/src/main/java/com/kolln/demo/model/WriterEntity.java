package com.kolln.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "writers")
public class WriterEntity {
    @Id
    private Long id;
    private String name;
}
