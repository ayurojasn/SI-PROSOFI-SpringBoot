package com.javeriana.prosofi.administrador.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javeriana.prosofi.administrador.model.Entidad;
import com.javeriana.prosofi.administrador.service.EntidadService;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/entidad")
public class EntidadController {

	private EntidadService entidadService;

	public EntidadController(final EntidadService entidadService) {

		this.entidadService = entidadService;
	}

	@PostMapping("/addEntidad")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Entidad> addEntidad(@NotNull @RequestBody Entidad entidad) {

		Entidad newEntidad = entidadService.addEntidad(entidad);
		return new ResponseEntity<Entidad>(newEntidad, HttpStatus.OK);
	}

	@GetMapping("/findAllEntidades")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Entidad>> findAllEntidades() {

		List<Entidad> entidades = entidadService.finaAllEntidades();
		return new ResponseEntity<List<Entidad>>(entidades, HttpStatus.OK);
	}

	@GetMapping("/findEntidadById/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Entidad> findById(@NotNull @PathVariable Long id) {

		Entidad entidad = entidadService.findEntidad(id).orElse(null);
		return new ResponseEntity<Entidad>(entidad, HttpStatus.OK);
	}

	@PutMapping("/updateEntidad/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Entidad> updatateById(@NotNull @PathVariable Long id,
														   @NotNull @RequestBody Entidad entidad) {

		Entidad newEntidad = entidadService.updateEntidad(entidad, id);
		return new ResponseEntity<Entidad>(newEntidad, HttpStatus.OK);
	}
}
