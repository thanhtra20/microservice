package com.example.petdemo.config;

import com.example.petdemo.client.api.AnimalControllerApi;
import com.example.petdemo.models.Animal;
import com.example.petdemo.models.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class AnimalApiClient {

  private final AnimalControllerApi animalControllerApi;

  public AnimalApiClient(AnimalControllerApi animalControllerApi) {
    this.animalControllerApi = animalControllerApi;
  }

  public List<Animal> findAll() {
    try {
      log.info("Find all {}", animalControllerApi.getApiClient().getBasePath());
      return animalControllerApi.findAll();
    } catch (Exception e) {
      log.error("Find all failed: {}", e.getLocalizedMessage());
      return new ArrayList<>();
    }
  }

  public Animal addAnimal(Animal animal){
    return animalControllerApi.saveOrUpdate(animal);
  }

  public void deleteAnimalById(String animalId){
    animalControllerApi.deleteAnimal(animalId);
  }



}