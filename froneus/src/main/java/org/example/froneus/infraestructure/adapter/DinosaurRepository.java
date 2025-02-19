package org.example.froneus.infraestructure.adapter;

import org.example.froneus.infraestructure.adapter.entity.DinosaurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DinosaurRepository extends JpaRepository<DinosaurEntity, Long> {
    Optional<DinosaurEntity> findByName(String name);
}
