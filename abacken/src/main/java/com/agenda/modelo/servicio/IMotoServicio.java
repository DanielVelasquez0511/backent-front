package com.agenda.modelo.servicio;

import java.util.List;

import com.agenda.modelo.entidad.Moto;

public interface IMotoServicio {
	// crear los métodos para los servicios CRUD
	public List<Moto> listaTodos();
	public void guardar(Moto moto);
	public Moto buscarPorId(Integer id);
	public void eleminar(Integer id);
}