package org.example.froneus.application.mapper;

import org.example.froneus.domain.model.Dinosaur;
import org.example.froneus.domain.model.dto.DinosaurDTO;

public class DinosaurDTOMapper {

    public static DinosaurDTO toDto(Dinosaur request) {
        DinosaurDTO dinosaur = new DinosaurDTO();
        dinosaur.setName(request.getName());
        dinosaur.setSpecies(request.getSpecies());
        dinosaur.setDiscoveryDate(request.getDiscoveryDate());
        dinosaur.setExtinctionDate(request.getExtinctionDate());
        dinosaur.setStatus(request.getStatus());
        return dinosaur;
    };
}
