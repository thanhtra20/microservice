package com.example.animalstore.services;

import com.example.animalstore.models.Animal;
import com.example.animalstore.repository.AnimalRepository;
import com.example.animalstore.server.api.AnimalApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalService implements AnimalApiDelegate {

    @Autowired
    AnimalRepository animalRepository;


    @Override
    public ResponseEntity<List<Animal>> findAll() {
        return ResponseEntity.ok(animalRepository.findAll());
    }

    @Override
    public ResponseEntity<Animal> saveOrUpdate(Animal animal) {
        return ResponseEntity.ok(animalRepository.save(animal));
    }

    @Override
    public ResponseEntity<Void> deleteAnimal(String animalId) {
       Animal animal = animalRepository.findById(animalId).get();
       animalRepository.delete(animal);
       return new ResponseEntity<Void>(HttpStatus.OK);


    }

    @Override
    public ResponseEntity<List<Animal>> findByType(String animalType) {
        List<Animal> animals = animalRepository.findByType(animalType);
        return ResponseEntity.ok(animals);
    }

    @Override
    public ResponseEntity<Animal> retrieveAnimal(String animalId) {
        Animal animal = animalRepository.findById(animalId).get();
        return ResponseEntity.ok(animal);
    }


}
