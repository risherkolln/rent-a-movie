package com.kolln.demo.repository;

import com.kolln.demo.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    int countById(Long id);
 //   MovieEntity getByDirector(Long id);
 //   MovieEntity getByStar(Long id);
}
