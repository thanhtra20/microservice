package com.example.petdemo.config;

import com.example.petdemo.models.Animal;
import com.example.petdemo.models.Pet;
import org.springframework.stereotype.Service;


public class AnimalConverter {


    public static Animal toAnimal(Pet pet) {
        Animal animal = new Animal();
        animal.setName(pet.getName());
        animal.setType(pet.getType());
        return animal;
    }

    public static Pet toPet(Animal animal){
        Pet pet = new Pet();
        pet.setName(animal.getName());
        pet.setType(animal.getType());
        return pet;
    }
}
