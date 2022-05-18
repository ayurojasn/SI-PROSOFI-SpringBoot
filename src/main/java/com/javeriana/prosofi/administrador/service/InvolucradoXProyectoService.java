package com.javeriana.prosofi.administrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.javeriana.prosofi.administrador.model.InvolucradoXProyecto;
import com.javeriana.prosofi.administrador.repository.InvolucradoXProyectoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
@Service
public class InvolucradoXProyectoService {

	@Autowired
	InvolucradoXProyectoRepository involucradoXProyectoRepository;

	public InvolucradoXProyectoService(final InvolucradoXProyectoRepository involucradoXProyectoRepository) {

		this.involucradoXProyectoRepository = involucradoXProyectoRepository;
	}

	public InvolucradoXProyecto addInvolucradoXProyecto(InvolucradoXProyecto involucradoXProyecto){
		return involucradoXProyectoRepository.save(involucradoXProyecto);
	}

	public InvolucradoXProyecto updateInvolucradoXProyecto(InvolucradoXProyecto involucradoXProyecto, Long involucradoXProyectoId){
		if(involucradoXProyectoRepository.findById(involucradoXProyectoId)!=null){
			return involucradoXProyectoRepository.save(involucradoXProyecto);
		}
		throw new EmptyResultDataAccessException("InvolucradoXProyecto no encontrado por id " + involucradoXProyectoId, 1);
	}

	public Optional<InvolucradoXProyecto> findInvolucradoXProyecto(Long involucradoXProyectoId) {
		return involucradoXProyectoRepository.findById(involucradoXProyectoId);
	}

	public List<InvolucradoXProyecto> finaAllInvolucradoXProyectos(){
		return involucradoXProyectoRepository.findAll();
	}

	public List<InvolucradoXProyecto> findByInvolucradoId(Long id){
		return involucradoXProyectoRepository.findByInvolucradoId(id);
	}

	public List<InvolucradoXProyecto> findByProyectoId(Long id){
		return involucradoXProyectoRepository.findByProyectoId(id);
	}

}
