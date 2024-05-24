package com.agenda.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="moto")
public class Moto {

	//Atributos que representan los campos en la BD
	@Id
	private int idMoto;
	private String marca;
	private String modelo;
	private int cilindraje;
	private double precio;
	
	//Constructor
	public Moto() {
		super();
	}
	
	//Metodos setter y getter
	public int getIdMoto() {
		return idMoto;
	}
	
	public void setIdMoto(int idMoto) {
		this.idMoto = idMoto;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}
	
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//Metodo toString
	@Override
	public String toString() {
		return "Moto [idMoto=" + idMoto + ", marca=" + marca + ", modelo=" + modelo + ", cilindraje=" + cilindraje
				+ ", precio=" + precio + "]";
	}
	
}