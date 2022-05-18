package com.javeriana.prosofi.administrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.javeriana.prosofi.administrador.model.Involucrado;
import com.javeriana.prosofi.administrador.repository.InvolucradoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
@Service
public class InvolucradoService {

	@Autowired
	InvolucradoRepository involucradoRepository;

	public InvolucradoService(final InvolucradoRepository involucradoRepository) {

		this.involucradoRepository = involucradoRepository;
	}

	public Involucrado addInvolucrado(Involucrado involucrado){
		return involucradoRepository.save(involucrado);
	}

	public Involucrado updateInvolucrado(Involucrado involucrado, Long involucradoId){
		if(involucradoRepository.findById(involucradoId)!=null){
			return involucradoRepository.save(involucrado);
		}
		throw new EmptyResultDataAccessException("docente no encontrada por id " + involucradoId, 1);
	}

	public Optional<Involucrado> findInvolucrado(Long involucradoId) {
		return involucradoRepository.findById(involucradoId);
	}

	public List<Involucrado> finaAllInvolucrados(){
		return involucradoRepository.findAll();
	}
}
