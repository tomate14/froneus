package org.example.froneus.infraestructure.adapter.entity;

import jakarta.persistence.*;
import org.example.froneus.domain.model.DinosaurStatus;

import java.time.LocalDateTime;

@Entity
public class DinosaurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String species;
    private LocalDateTime discoveryDate;
    private LocalDateTime extinctionDate;

    @Enumerated(EnumType.STRING)
    private DinosaurStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
