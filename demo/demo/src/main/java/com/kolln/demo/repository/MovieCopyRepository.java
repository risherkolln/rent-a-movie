package com.kolln.demo.repository;

import com.kolln.demo.model.MovieCopyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieCopyRepository extends JpaRepository<MovieCopyEntity, Long> {
  //  @Query("SELECT mc FROM movie_copies mc JOIN rentals WHERE ")
  //  List<MovieCopyEntity> findAvailableMovieCopyByFormat(Long movieId, Long formatId);
}
