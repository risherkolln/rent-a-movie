package com.kolln.demo.repository;

import com.kolln.demo.model.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
    List<GenreEntity> findByIdIn(List<Long> ids);
}
