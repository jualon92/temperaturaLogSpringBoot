package com.example.demo.temperatura;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TemperaturaRepository extends MongoRepository<Temperatura, String> {
}