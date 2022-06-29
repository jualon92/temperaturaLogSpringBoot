package com.example.demo.temperatura;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
@Service
public class TemperaturaService {
	
	@Autowired
	private TemperaturaRepository temperaturaRepository;
	

	public void addTemperatura(Double grados) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("America/Buenos_Aires"));
	 
		Temperatura temperaturaNueva = new Temperatura(df.format(date), grados);
				
		temperaturaRepository.save(temperaturaNueva);
	}
	
	public Temperatura findFirst() {
		return  temperaturaRepository.findFirstByOrderByIdDesc();
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
