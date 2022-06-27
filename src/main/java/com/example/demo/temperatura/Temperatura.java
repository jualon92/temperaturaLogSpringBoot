package com.example.demo.temperatura;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
import lombok.Data;

@Data
@Document(collection = "temperaturas")
public class Temperatura {
	
	@Id
	private String id;
	private String fecha;
	private Double grados;
	
	public Temperatura(  String fecha, Double grados) {
		 
		this.fecha = fecha;
		this.grados = grados;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getGrados() {
		return grados;
	}

	public void setGrados(Double grados) {
		this.grados = grados;
	} 
	
}
