package org.example.froneus.application.mapper;

import org.example.froneus.domain.model.Dinosaur;
import org.example.froneus.domain.model.request.DinosaurMessageRequest;

import java.time.LocalDateTime;

public class DinosaurMessagingMapper {
    public static DinosaurMessageRequest toDto(Dinosaur request) {
        DinosaurMessageRequest dinosaur = new DinosaurMessageRequest();
        dinosaur.setDinosaurId(request.getId());
        dinosaur.setNewStatus(request.getStatus().name());
        dinosaur.setTimestamp(LocalDateTime.now());

        return dinosaur;
    };
}
