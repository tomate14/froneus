package org.example.froneus.domain.port;

import org.example.froneus.domain.model.Dinosaur;

public interface DinosaurMessagePublisherPort {
    void publishDinosaurUpdated(Dinosaur dinosaur);
}
