package com.example.demo.temperatura;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	
	public Temperatura findHourAgo() {
		
		/*
		//averiguar cuando fue hace 1 hora.   findFirstByDateBetween(initialDate, 1hourAGODate)
		 
		//obtener fecha antes en string de db
		Temperatura temperaturaActual = temperaturaRepository.findFirstByOrderByIdDesc();
		String fechaEnString = temperaturaActual.getFecha();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("America/Buenos_Aires"));
		
		//obtener Date fechaInicial
		Date fechaInicial = null;
		try {
			fechaInicial = df.parse(fechaEnString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 //obtener que hora era N minutos atras
		Calendar cal = Calendar.getInstance();
		// remove next line if you're always using the current time.
		cal.setTime(fechaInicial);
		cal.add(Calendar.MINUTE, -3);
		Date oneHourBack = cal.getTime();
		
		
		 return temperaturaRepository.findAllByFechaBetween(fechaInicial, oneHourBack);
		 
		*/
		
		 
		List <Temperatura> listaTemperaturas = temperaturaRepository.findFirst2ByOrderByIdDesc();
		Integer indiceUltimo = listaTemperaturas.size() - 1;
		return listaTemperaturas.get(indiceUltimo);
		 
	}
	
	public List <Temperatura> findAllTemperaturas(Integer cantidad){
		return temperaturaRepository.findAllByOrderByIdDesc(PageRequest.of(0, cantidad));
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
