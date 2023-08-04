package com.kolln.demo.repository;

import com.kolln.demo.model.GenresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenresEntity, Long> {
}
