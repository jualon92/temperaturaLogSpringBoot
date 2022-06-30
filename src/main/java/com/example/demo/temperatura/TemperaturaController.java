package com.example.demo.temperatura;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 
 
@RestController
public class TemperaturaController {

	 
		@Autowired
		private TemperaturaService temperaturaService;
		
		@RequestMapping("/temperaturas")
		public ArrayList<Temperatura> getTemperaturas() {
			return temperaturaService.getAllTemperaturas();
		}
		
		@RequestMapping("/temperaturas/{id}")
		public Temperatura getTemperatura(@PathVariable String id) {
			return temperaturaService.getTemperatura(id);
		}
		
		
		@RequestMapping("/temperaturas/actual")
		public Temperatura getTemperatura() {
			return temperaturaService.findFirst();
		}
		
		@RequestMapping("/temperaturas/tendencia")
		public Temperatura  getTendencia() {
			return temperaturaService.findHourAgo();
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/temperaturas/{id}")
		public void deleteTemperatura(@PathVariable String id) {
		 temperaturaService.deleteTemperatura(id);
		}
		
		
		@RequestMapping(method=RequestMethod.PUT, value="/temperaturas/{id}")
		public void updateTemperatura(@RequestBody Temperatura temperatura, @PathVariable String id) {
		 temperaturaService.updateTemperatura(id, temperatura);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/temperaturas")
		public void postTemperatura(@RequestBody Double grados) { //arduino pasa grados medicion como param
		 temperaturaService.addTemperatura(grados);
		}
}
