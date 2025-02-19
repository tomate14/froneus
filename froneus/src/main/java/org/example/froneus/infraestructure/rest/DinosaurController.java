package org.example.froneus.infraestructure.rest;

import org.example.froneus.application.service.DinosaurService;
import org.example.froneus.domain.model.dto.DinosaurDTO;
import org.example.froneus.domain.model.request.DinosaurRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dinosaur")
public class DinosaurController {

    private final DinosaurService dinosaurService;

    public DinosaurController(DinosaurService dinosaurService) {
        this.dinosaurService = dinosaurService;
    }

    @PostMapping
    public ResponseEntity<DinosaurDTO> createDinosaur(@RequestBody DinosaurRequest dinosaur) {
        DinosaurDTO created = dinosaurService.createDinosaur(dinosaur);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DinosaurDTO>> getAllDinosaurs() {
        List<DinosaurDTO> dinosaurs = dinosaurService.getAllDinosaurs();
        return new ResponseEntity<>(dinosaurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DinosaurDTO> getDinosaurById(@PathVariable Long id) {
        return dinosaurService.getDinosaurById(id)
                .map(dinosaur -> new ResponseEntity<>(dinosaur, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DinosaurDTO> updateDinosaur(@PathVariable Long id, @RequestBody DinosaurRequest dinosaur) {
        DinosaurDTO updated = dinosaurService.updateDinosaur(id, dinosaur);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDinosaur(@PathVariable Long id) {
        dinosaurService.deleteDinosaur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
