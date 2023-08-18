package com.kolln.demo.repository;

import com.kolln.demo.model.MovieEntity;
import com.kolln.demo.model.dto.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    int countById(Long id);
    List<MovieEntity> getByDirector_Id(Long id);
    List<MovieEntity> getByStars_Id(Long id);

   // @Query("SELECT m FROM MovieEntity m JOIN movie_genres mg JOIN GenreEntity g WHERE m.id = mg.movie_id and g.id = mg.genre_id and g.id = :id")
    List<MovieEntity> getByGenresId(Long id);
 //   List<MovieEntity> findTop10ByOrderByPopularRatingDesc();
    List<MovieEntity> findTop10ByOrderByFormalRatingDesc();

//    List<Movie> findAvailableByNameAndFormat_Id(String name, Long format);
}
