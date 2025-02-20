package org.example.froneus.application.scheduler;

import org.example.froneus.domain.model.Dinosaur;
import org.example.froneus.domain.model.DinosaurStatus;
import org.example.froneus.domain.port.DinosaurMessagePublisherPort;
import org.example.froneus.domain.port.DinosaurRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DinosaurStatusScheduler {
    @Autowired
    private DinosaurRepositoryPort dinosaurRepository;
    @Autowired
    private DinosaurMessagePublisherPort messagePublisher;

    @Scheduled(fixedRate = 60000)
    public void updateDinosaurStatuses() {
        List<Dinosaur> dinosaurs = dinosaurRepository.findAll();
        LocalDateTime now = LocalDateTime.now();

        dinosaurs.forEach(dinosaur -> {
            if (now.isAfter(dinosaur.getExtinctionDate()) || now.isEqual(dinosaur.getExtinctionDate())) {
                if (dinosaur.getStatus() != DinosaurStatus.EXTINCT) {
                    dinosaur.setStatus(DinosaurStatus.EXTINCT);
                    dinosaurRepository.update(dinosaur);
                    messagePublisher.publishDinosaurUpdated(dinosaur);
                }
            } else if (dinosaur.getStatus() == DinosaurStatus.ALIVE) {
                LocalDateTime endangeredThreshold = dinosaur.getExtinctionDate().minusHours(24);
                if (now.isAfter(endangeredThreshold) || now.isEqual(endangeredThreshold)) {
                    dinosaur.setStatus(DinosaurStatus.ENDANGERED);
                    dinosaurRepository.update(dinosaur);
                    messagePublisher.publishDinosaurUpdated(dinosaur);
                }
            }
        });
    }

}
