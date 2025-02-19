package org.example.froneus.domain.model.request;

import org.example.froneus.domain.model.DinosaurStatus;

import java.time.LocalDateTime;

public class DinosaurRequest {
    private String name;
    private String species;
    private LocalDateTime discoveryDate;
    private LocalDateTime extinctionDate;
    private DinosaurStatus status;

    public DinosaurRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public LocalDateTime getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(LocalDateTime discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    public LocalDateTime getExtinctionDate() {
        return extinctionDate;
    }

    public void setExtinctionDate(LocalDateTime extinctionDate) {
        this.extinctionDate = extinctionDate;
    }

    public DinosaurStatus getStatus() {
        return status;
    }

    public void setStatus(DinosaurStatus status) {
        this.status = status;
    }
}
