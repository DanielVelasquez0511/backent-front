package com.agenda.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agenda.modelo.entidad.Moto;
@Repository
public interface MotoRepositorio extends CrudRepository<Moto, Integer> {

}