package com.kolln.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "movie_copies")
public class MovieCopyEntity {
    @Id
    private Long id;
    private String serialNumber;
  /*  @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;
    @ManyToOne
    @JoinColumn(name = "format_id")
    private FormatEntity format;*/
}
