package org.example.froneus.infraestructure.adapter;

import jakarta.transaction.Transactional;
import org.example.froneus.application.mapper.DinosaurDBOMapper;
import org.example.froneus.domain.model.Dinosaur;
import org.example.froneus.domain.port.DinosaurRepositoryPort;
import org.example.froneus.infraestructure.adapter.entity.DinosaurEntity;
import org.example.froneus.infraestructure.adapter.repository.DinosaurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DinosaurJPAAdapter implements DinosaurRepositoryPort {

    private final DinosaurRepository dinosaurRepository;

    public DinosaurJPAAdapter(DinosaurRepository dinosaurRepository) {
        this.dinosaurRepository = dinosaurRepository;
    }


    @Transactional
    @Override
    public Dinosaur save(Dinosaur dinosaur) {
        DinosaurEntity dino = DinosaurDBOMapper.toDbo(dinosaur);
        DinosaurEntity saved = dinosaurRepository.save(dino);
        return DinosaurDBOMapper.toDomain(saved);
    }

    @Override
    public List<Dinosaur> findAll() {

        return dinosaurRepository.findAll()
                .stream()
                .map(DinosaurDBOMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Dinosaur> findById(Long id) {
        Optional<DinosaurEntity> optionalDinosaur = dinosaurRepository.findById(id);

        if (optionalDinosaur.isEmpty()){
            throw new RuntimeException(String.format("Not found dinosaur whit id %s", id));
        }

        return Optional.of(DinosaurDBOMapper.toDomain(optionalDinosaur.get()));
    }

    @Override
    public Optional<Dinosaur> findByName(String name) {
        Optional<DinosaurEntity> optionalDinosaur = dinosaurRepository.findByName(name);
        if (optionalDinosaur.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(DinosaurDBOMapper.toDomain(optionalDinosaur.get()));
    }

    @Transactional
    @Override
    public Dinosaur update(Dinosaur dinosaur) {
        DinosaurEntity dinosaurToUpdate = DinosaurDBOMapper.toDbo(dinosaur);
        DinosaurEntity dinosaurUpdated = dinosaurRepository.save(dinosaurToUpdate);

        return DinosaurDBOMapper.toDomain(dinosaurUpdated);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        dinosaurRepository.deleteById(id);
    }
}
