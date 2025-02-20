package org.example.froneus.application.mapper;

import org.example.froneus.domain.model.Dinosaur;
import org.example.froneus.infraestructure.adapter.entity.DinosaurEntity;

public class DinosaurDBOMapper {

    public static Dinosaur toDomain(DinosaurEntity request) {
        Dinosaur dinosaur = new Dinosaur();
        dinosaur.setId(request.getId());
        dinosaur.setName(request.getName());
        dinosaur.setSpecies(request.getSpecies());
        dinosaur.setDiscoveryDate(request.getDiscoveryDate());
        dinosaur.setExtinctionDate(request.getExtinctionDate());
        dinosaur.setStatus(request.getStatus());
        return dinosaur;
    };

    public static DinosaurEntity toDbo(Dinosaur request) {
        DinosaurEntity dinosaur = new DinosaurEntity();
        if (request.getId() != null) {
            dinosaur.setId(request.getId());
        }
        dinosaur.setName(request.getName());
        dinosaur.setSpecies(request.getSpecies());
        dinosaur.setDiscoveryDate(request.getDiscoveryDate());
        dinosaur.setExtinctionDate(request.getExtinctionDate());
        dinosaur.setStatus(request.getStatus());
        return dinosaur;
    };
}
