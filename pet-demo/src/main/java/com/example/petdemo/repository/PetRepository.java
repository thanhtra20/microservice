package com.example.petdemo.repository;

import com.example.petdemo.models.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {
//   List<Pet> findByType(String type);
//
}
