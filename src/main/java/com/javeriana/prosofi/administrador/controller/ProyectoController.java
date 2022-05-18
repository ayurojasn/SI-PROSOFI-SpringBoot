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
import com.javeriana.prosofi.administrador.model.Proyecto;
import com.javeriana.prosofi.administrador.service.EntidadService;
import com.javeriana.prosofi.administrador.service.ProyectoService;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

	private ProyectoService proyectoService;

	public ProyectoController(final ProyectoService proyectoService) {

		this.proyectoService = proyectoService;
	}

	@PostMapping("/addProyecto")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Proyecto> addEntidad(@NotNull @RequestBody Proyecto entidad) {

		Proyecto newProyecto = proyectoService.addProyecto(entidad);
		return new ResponseEntity<Proyecto>(newProyecto, HttpStatus.OK);
	}

	@GetMapping("/findAllProyectos")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Proyecto>> findAllProyectos() {

		List<Proyecto> proyectos = proyectoService.finaAllProyectos();
		return new ResponseEntity<List<Proyecto>>(proyectos, HttpStatus.OK);
	}

	@GetMapping("/findProyectoById/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Proyecto> findById(@NotNull @PathVariable Long id) {

		Proyecto proyecto = proyectoService.findProyecto(id).orElse(null);

		return new ResponseEntity<Proyecto>(proyecto, HttpStatus.OK);
	}

	@PutMapping("/updateProyecto/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Proyecto> updatateById(@NotNull @PathVariable Long id,
												@NotNull @RequestBody Proyecto entidad) {

		Proyecto newProyecto = proyectoService.updateProyecto(entidad, id);
		return new ResponseEntity<Proyecto>(newProyecto, HttpStatus.OK);
	}
}
