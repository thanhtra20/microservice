package com.example.animalstore.repository;

import com.example.animalstore.models.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends MongoRepository<Animal, String> {
     List<Animal> findByType(String type);
}
