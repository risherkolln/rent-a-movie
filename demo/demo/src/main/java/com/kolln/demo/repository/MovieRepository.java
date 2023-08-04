package com.kolln.demo.repository;

import com.kolln.demo.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    int countById(Long id);
    List<MovieEntity> getByDirector_Id(Long id);
    List<MovieEntity> getByStar_Id(Long id);
    List<MovieEntity> getByGenres_Id(Long id);
    List<MovieEntity> findTop10ByOrderByPopularRatingDesc();
    List<MovieEntity> findTop10ByOrderByFormalRatingDesc();
}
