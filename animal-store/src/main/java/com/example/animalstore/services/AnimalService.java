package com.example.animalstore.services;

import com.example.animalstore.models.Animal;
import com.example.animalstore.repository.AnimalRepository;
import com.example.animalstore.server.api.AnimalApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService implements AnimalApiDelegate {

    @Autowired
    AnimalRepository animalRepository;


    @Override
    public ResponseEntity<List<Animal>> findAll() {
        //  return ResponseEntity.ok(new ArrayList<>());
        return ResponseEntity.ok(animalRepository.findAll());
    }

    @Override
    public ResponseEntity<Animal> saveOrUpdate(Animal animal) {
        return AnimalApiDelegate.super.saveOrUpdate(animal);
    }
//
//    @Override
//    public ResponseEntity<Void> deleteAnimal(String animalId) {
//
//    }



}
