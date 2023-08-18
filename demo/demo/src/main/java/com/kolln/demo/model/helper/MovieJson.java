package com.kolln.demo.model.helper;

import com.kolln.demo.model.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieJson {
    private String name;
    private List<Long> genres;
    private Long directorId;
    private List<Long> stars;
    private List<Long> writers;
    private int formalRating;
}
