package org.example.froneus.application.service;

import org.example.froneus.domain.model.dto.DinosaurDTO;
import org.example.froneus.domain.model.request.DinosaurRequest;

import java.util.List;
import java.util.Optional;

public interface DinosaurService {
    DinosaurDTO createDinosaur(DinosaurRequest dinosaur);
    List<DinosaurDTO> getAllDinosaurs();
    Optional<DinosaurDTO> getDinosaurById(Long id);
    DinosaurDTO updateDinosaur(Long id, DinosaurRequest updatedData);
    void deleteDinosaur(Long id);
}
