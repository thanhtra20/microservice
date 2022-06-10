package com.example.petdemo.services;

import com.example.petdemo.client.api.AnimalControllerApi;
import com.example.petdemo.config.AnimalApiClient;
import com.example.petdemo.config.AnimalConverter;
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

    @Autowired
    private AnimalApiClient animalApiClient;

    @Autowired
    private PetRepository petRepository;

//    @Override
//    public ResponseEntity<List<Pet>> findPetsByStatus(String status) {
//      List<Pet> pets = petRepository.findByStatus(status);
//      return ResponseEntity.ok(pets);
//
//    }


//    @Override
//    public ResponseEntity<List<Pet>> findPetsByType(String type) {
//        List<Pet> pets = petRepository.findByType(type);
//
//    }

    @Override
    public ResponseEntity<Void> addDogs() {
        List<Animal> animals = animalApiClient.findAll();

//        animals.stream()
//                .filter(animal -> animal.getType().equals("dog"))
//                .map(dog -> AnimalConverter.toPet(dog))
//                .forEach(dogP -> petRepository.save(dogP));

        for (Animal animal: animals) {
            if(animal.getType().equals("dog")){
                Pet dog = AnimalConverter.toPet(animal);
                petRepository.save(dog);
                animalApiClient.deleteAnimalById(animal.getId());
            }
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> addPet(Pet body) {
        petRepository.save(body);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Void> updatePet(Pet body) {
        return PetApiDelegate.super.updatePet(body);
    }

    @Override
    public ResponseEntity<Void> deletePet(String petId) {
        Optional<Pet> pet = petRepository.findById(petId);
        if (pet.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        Animal animal = AnimalConverter.toAnimal(pet.get());
        petRepository.deleteById(petId);

        animalApiClient.addAnimal(animal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    public ResponseEntity<List<Pet>> getAllPets(){
//        List<Animal> animals = animalApiClient.findAll();
//        return ResponseEntity.ok(new ArrayList<>());
//    }
}
