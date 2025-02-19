package org.example.froneus.application.mapper;

import org.example.froneus.domain.model.Dinosaur;
import org.example.froneus.domain.model.request.DinosaurRequest;


public class DinosaurRequestMapper {

    public static Dinosaur toDomain(DinosaurRequest request) {
        Dinosaur dinosaur = new Dinosaur();
        dinosaur.setName(request.getName());
        dinosaur.setSpecies(request.getSpecies());
        dinosaur.setDiscoveryDate(request.getDiscoveryDate());
        dinosaur.setExtinctionDate(request.getExtinctionDate());
        dinosaur.setStatus(request.getStatus());
        return dinosaur;
    };
}
