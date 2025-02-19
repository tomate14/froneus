package org.example.froneus.domain.port;

import org.example.froneus.domain.model.Dinosaur;

import java.util.List;
import java.util.Optional;

public interface DinosaurRepositoryPort {
    Dinosaur save(Dinosaur dinosaur);
    List<Dinosaur> findAll();
    Optional<Dinosaur> findById(Long id);
    Optional<Dinosaur> findByName(String name);
    Dinosaur update(Dinosaur dinosaur);
    void deleteById(Long id);
}
