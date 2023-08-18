package com.kolln.demo.repository;

import com.kolln.demo.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<MovieEntity, Long> {
}
