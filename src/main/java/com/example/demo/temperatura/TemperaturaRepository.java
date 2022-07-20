package com.example.demo.temperatura;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TemperaturaRepository extends MongoRepository<Temperatura, String> {
	 
	public Temperatura findFirstByOrderByIdDesc();
	public List <Temperatura> findFirst2ByOrderByIdDesc();
	public List <Temperatura> findFirst12ByOrderByIdDesc();
	public List <Temperatura> findAllByFechaBetween(Date fechaInicial, Date oneHourBack);
	public List <Temperatura> findAllByOrderByIdDesc(Pageable pageable);
	
	public Temperatura findFirstByOrderByGradosDesc();  //returns max temp of record.
	 //obtener 10 entradas. encontrar el mayor.
	//encontrar 7.       =>  tomar el max 
	 
}