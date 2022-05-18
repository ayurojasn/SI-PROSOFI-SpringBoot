package com.javeriana.prosofi.administrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.javeriana.prosofi.administrador.model.Proyecto;
import com.javeriana.prosofi.administrador.repository.ProyectoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
@Service
public class ProyectoService {

	@Autowired
	ProyectoRepository proyectoRepository;

	public ProyectoService(final ProyectoRepository proyectoRepository) {

		this.proyectoRepository = proyectoRepository;
	}

	public Proyecto addProyecto(Proyecto proyecto){
		return proyectoRepository.save(proyecto);
	}

	public Proyecto updateProyecto(Proyecto proyecto, Long proyectoId){
		if(proyectoRepository.findById(proyectoId)!=null){
			return proyectoRepository.save(proyecto);
		}
		throw new EmptyResultDataAccessException("proyecto no encontrado por id: "+ proyectoId, 1);
	}

	public Optional<Proyecto> findProyecto(Long proyectoId) {
		return proyectoRepository.findById(proyectoId);
	}

	public List<Proyecto> finaAllProyectos(){
		return proyectoRepository.findAll();
	}
}
