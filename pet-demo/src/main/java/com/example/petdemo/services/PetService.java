package com.example.petdemo.services;

import com.example.petdemo.client.api.AnimalControllerApi;
import com.example.petdemo.config.AnimalApiClient;
import com.example.petdemo.models.Animal;
import com.example.petdemo.models.Pet;
import com.example.petdemo.repository.PetRepository;
import com.example.petdemo.server.api.PetApi;
import com.example.petdemo.server.api.PetApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService implements PetApiDelegate {


    private AnimalApiClient animalApiClient;

    @Autowired
    private PetRepository petRepository;

    @Override
    public ResponseEntity<List<Pet>> findPetsByStatus(String status) {
      List<Pet> pets = petRepository.findByStatus(status);
      return ResponseEntity.ok(pets);

    }

    @Override
    public ResponseEntity<Void> addPet(Pet body) {
        petRepository.save(body);
        animalApiClient

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Void> updatePet(Pet body) {
        return PetApiDelegate.super.updatePet(body);
    }

    @Override
    public ResponseEntity<Void> deletePet(String petId) {
        Pet pet = petRepository.findById(petId).get();
        petRepository.deleteById(petId);
        Animal animal = new Animal();
        animal.setId(petId);
        animal.setName(pet.getName());
        animal.setType("abc");
        animalApiClient.addAnimal(animal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Pet>> getAllPets(){
        List<Animal> animals = animalApiClient.findAll();
        return ResponseEntity.ok(new ArrayList<>());
    }
}
