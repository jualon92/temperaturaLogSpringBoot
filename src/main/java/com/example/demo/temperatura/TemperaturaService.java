package com.example.demo.temperatura;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
@Service
public class TemperaturaService {
	
	@Autowired
	private TemperaturaRepository temperaturaRepository;
	

	public void addTemperatura(Temperatura nuevaTemperatura) {
		temperaturaRepository.save(nuevaTemperatura);
	}
	
	public ArrayList<Temperatura> getAllTemperaturas() {
		ArrayList <Temperatura> temperaturas = new ArrayList<>(); //ini arraylist
		temperaturaRepository.findAll().forEach( e -> temperaturas.add(e)); 
		return temperaturas;
	}
	
	
	public Temperatura getTemperatura(String id) {
		return temperaturaRepository.findById(id).orElse(null);
	}
	public void deleteTemperatura(String id) {
		temperaturaRepository.deleteById(id);
	}
	
	public void updateTemperatura(String id, Temperatura nuevaTemperatura) {
		temperaturaRepository.save(nuevaTemperatura); //repo knows if object with id exists, update. else insert
	}
	
	
	
}
