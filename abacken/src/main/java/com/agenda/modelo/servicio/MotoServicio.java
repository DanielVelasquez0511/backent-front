package com.agenda.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.modelo.entidad.Moto;
import com.agenda.modelo.repositorio.MotoRepositorio;

@Service
public class MotoServicio implements IMotoServicio {
    //paea inyectar las dependencias 
	@Autowired
	private MotoRepositorio motoRepositorio;
	
	@Override
	public List<Moto> listaTodos() {
		return (List<Moto>)motoRepositorio.findAll();
	}

	@Override
	public void guardar(Moto moto) {
		motoRepositorio.save(moto);
	}

	@Override
	public Moto buscarPorId(Integer id) {
		
		return motoRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eleminar(Integer id) {
		motoRepositorio.deleteById(id);

	}

}