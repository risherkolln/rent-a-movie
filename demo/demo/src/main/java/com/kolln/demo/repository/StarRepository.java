package com.kolln.demo.repository;

import com.kolln.demo.model.StarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StarRepository extends JpaRepository<StarEntity, Long> {
    List<StarEntity> findByIdIn(List<Long> ids);
}
