package com.example.demo.temperatura;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TemperaturaRepository extends MongoRepository<Temperatura, String> {
	 
	public Temperatura findFirstByOrderByIdDesc();
}