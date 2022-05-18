package com.javeriana.prosofi.administrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.javeriana.prosofi.administrador.model.Entidad;
import com.javeriana.prosofi.administrador.repository.EntidadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
@Service
public class EntidadService {

	@Autowired
	EntidadRepository entidadRepository;

	public EntidadService(final EntidadRepository entidadRepository) {

		this.entidadRepository = entidadRepository;
	}

	public Entidad addEntidad(Entidad entidad){
		return entidadRepository.save(entidad);
	}

	public Entidad updateEntidad(Entidad entidad, Long entidadId){
		if(entidadRepository.findById(entidadId)!=null){
			return entidadRepository.save(entidad);
		}
		throw new EmptyResultDataAccessException("Entidad no encontrada por id " + entidadId, 1);
	}

	public Optional<Entidad> findEntidad(Long entidadId) {
		return entidadRepository.findById(entidadId);
	}

	public List<Entidad> finaAllEntidades(){
		return entidadRepository.findAll();
	}
}
