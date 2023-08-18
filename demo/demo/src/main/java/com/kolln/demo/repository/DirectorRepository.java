package com.kolln.demo.repository;

import com.kolln.demo.model.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<DirectorEntity, Long> {
}
