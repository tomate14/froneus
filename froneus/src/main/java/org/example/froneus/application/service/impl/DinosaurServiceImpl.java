package org.example.froneus.application.service.impl;

import org.example.froneus.application.service.DinosaurService;
import org.example.froneus.application.mapper.DinosaurDTOMapper;
import org.example.froneus.application.mapper.DinosaurRequestMapper;
import org.example.froneus.domain.model.Dinosaur;
import org.example.froneus.domain.model.DinosaurStatus;
import org.example.froneus.domain.model.dto.DinosaurDTO;
import org.example.froneus.domain.model.request.DinosaurRequest;
import org.example.froneus.domain.port.DinosaurRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DinosaurServiceImpl implements DinosaurService {
    @Autowired
    private DinosaurRepositoryPort dinosaurRepositoryPort;


    public DinosaurDTO createDinosaur(DinosaurRequest dinosaur) {
        if (dinosaurRepositoryPort.findByName(dinosaur.getName()).isPresent()) {
            throw new IllegalArgumentException("Name is not unique.");
        }
        if (dinosaur.getDiscoveryDate().isAfter(dinosaur.getExtinctionDate())) {
            throw new IllegalArgumentException("Discovery Date should be less than Extinction Date.");
        }

        Dinosaur dinosaurDbo = DinosaurRequestMapper.toDomain(dinosaur);
        dinosaurDbo.setStatus(DinosaurStatus.ALIVE);
        Dinosaur saved = dinosaurRepositoryPort.save(dinosaurDbo);
        return DinosaurDTOMapper.toDto(saved);
    }

    public List<DinosaurDTO> getAllDinosaurs() {
        List<Dinosaur> dinosaurs = dinosaurRepositoryPort.findAll();
        return dinosaurs.stream()
                .map(DinosaurDTOMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<DinosaurDTO> getDinosaurById(Long id) {
        Optional<Dinosaur> dinosaur = dinosaurRepositoryPort.findById(id);
        if (dinosaur.isPresent()) {
            return Optional.of(DinosaurDTOMapper.toDto(dinosaur.get()));
        }
        throw new IllegalArgumentException(String.format("Not found dinosaur whit id %s", id));
    }

    public DinosaurDTO updateDinosaur(Long id, DinosaurRequest updatedData) {
        Dinosaur existing = dinosaurRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Not found dinosaur whit id %s", id)));

        if (updatedData.getDiscoveryDate().isAfter(updatedData.getExtinctionDate())) {
            throw new IllegalArgumentException("Discovery Date should be less than Extinction Date.");
        }
        if (dinosaurRepositoryPort.findByName(updatedData.getName()).isPresent()) {
            throw new IllegalArgumentException("Name is not unique.");
        }

        if (existing.getStatus() == DinosaurStatus.EXTINCT) {
            throw new IllegalStateException("EXTINCT dinosaur couldn't be updated.");
        }

        Dinosaur dinosaur = DinosaurRequestMapper.toDomain(updatedData);

        Dinosaur updated = dinosaurRepositoryPort.update(dinosaur);
        return DinosaurDTOMapper.toDto(updated);
    }

    public void deleteDinosaur(Long id) {
        dinosaurRepositoryPort.deleteById(id);
    }

    private void checkDinosaurAbleByNameAndDates(DinosaurRequest updatedData) {
        if (updatedData.getDiscoveryDate().isAfter(updatedData.getExtinctionDate())) {
            throw new IllegalArgumentException("Discovery Date should be less than Extinction Date.");
        }
        if (dinosaurRepositoryPort.findByName(updatedData.getName()).isPresent()) {
            throw new IllegalArgumentException("Name is not unique.");
        }
    }
}
