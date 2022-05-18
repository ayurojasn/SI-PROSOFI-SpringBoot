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
import com.javeriana.prosofi.administrador.model.ResponsableEntidad;
import com.javeriana.prosofi.administrador.service.ResponsableEntidadService;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/responsableEntidad")
public class ResponsableEntidadController {

	private ResponsableEntidadService responsableEntidadService;

	public ResponsableEntidadController(final ResponsableEntidadService responsableEntidadService) {

		this.responsableEntidadService = responsableEntidadService;
	}

	@PostMapping("/addResponsable")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ResponsableEntidad> addResponsable(@NotNull @RequestBody ResponsableEntidad responsableEntidad) {

		ResponsableEntidad newResponsableEntidad = responsableEntidadService.addResponsableEntidad(responsableEntidad);
		return new ResponseEntity<ResponsableEntidad>(newResponsableEntidad, HttpStatus.OK);
	}

	@GetMapping("/findAllResponsables")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<ResponsableEntidad>> findAllResponsables() {

		List<ResponsableEntidad> responsables = responsableEntidadService.finaAllResponsables();
		return new ResponseEntity<List<ResponsableEntidad>>(responsables, HttpStatus.OK);
	}

	@GetMapping("/findResponsableById/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ResponsableEntidad> findById(@NotNull @PathVariable Long id) {

		ResponsableEntidad responsables = responsableEntidadService.findResponsableEntidad(id).orElse(null);
		return new ResponseEntity<ResponsableEntidad>(responsables, HttpStatus.OK);
	}

	@PutMapping("/updateResponsable/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ResponsableEntidad> updatateById(@NotNull @PathVariable Long id,
														   @NotNull @RequestBody ResponsableEntidad responsableEntidad) {

		ResponsableEntidad responsable = responsableEntidadService.updateResponsableEntidad(responsableEntidad, id);
		return new ResponseEntity<ResponsableEntidad>(responsable, HttpStatus.OK);
	}

}
