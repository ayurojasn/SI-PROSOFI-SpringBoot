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
import com.javeriana.prosofi.administrador.model.InvolucradoXProyecto;
import com.javeriana.prosofi.administrador.service.InvolucradoXProyectoService;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/involucradoXProyecto")
public class InvolucradoXProyectoController {


	private InvolucradoXProyectoService involucradoXProyectoService;

	public InvolucradoXProyectoController(final InvolucradoXProyectoService involucradoXProyectoService) {

		this.involucradoXProyectoService = involucradoXProyectoService;
	}

	@PostMapping("/addInvolucradoXProyecto")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<InvolucradoXProyecto> add(@NotNull @RequestBody InvolucradoXProyecto involucradoXProyecto) {

		InvolucradoXProyecto newInvolucradoXProyecto = involucradoXProyectoService.addInvolucradoXProyecto(involucradoXProyecto);
		return new ResponseEntity<InvolucradoXProyecto>(newInvolucradoXProyecto, HttpStatus.OK);
	}

	@GetMapping("/findAllInvolucradosXProyecto")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<InvolucradoXProyecto>> findAll() {

		List<InvolucradoXProyecto> involucradosXProyecto = involucradoXProyectoService.finaAllInvolucradoXProyectos();
		return new ResponseEntity<List<InvolucradoXProyecto>>(involucradosXProyecto, HttpStatus.OK);
	}

	@GetMapping("/findInvolucradoXProyectoById/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<InvolucradoXProyecto> findById(@NotNull @PathVariable Long id) {

		InvolucradoXProyecto involucradoXProyecto = involucradoXProyectoService.findInvolucradoXProyecto(id).orElse(null);
		return new ResponseEntity<InvolucradoXProyecto>(involucradoXProyecto, HttpStatus.OK);
	}

	@PutMapping("/updateInvolucradoXProyecto/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<InvolucradoXProyecto> updateById(@NotNull @PathVariable Long id,
												@NotNull @RequestBody InvolucradoXProyecto involucradoXProyecto) {

		InvolucradoXProyecto newInvolucradoXProyecto = involucradoXProyectoService.updateInvolucradoXProyecto(involucradoXProyecto, id);
		return new ResponseEntity<InvolucradoXProyecto>(newInvolucradoXProyecto, HttpStatus.OK);
	}

	@GetMapping("/findInvolucradoXProyectoByInvolucradoId/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<InvolucradoXProyecto>> findByInvolucradoId(@NotNull @PathVariable Long id) {

		List<InvolucradoXProyecto> involucradosXProyecto =  involucradoXProyectoService.findByInvolucradoId(id);
		return new ResponseEntity<List<InvolucradoXProyecto>>(involucradosXProyecto, HttpStatus.OK);
	}

	@GetMapping("/findInvolucradoXProyectoByProyectoId/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<InvolucradoXProyecto>> findByProyectoId(@NotNull @PathVariable Long id) {

		List<InvolucradoXProyecto> involucradosXProyecto =  involucradoXProyectoService.findByProyectoId(id);
		return new ResponseEntity<List<InvolucradoXProyecto>>(involucradosXProyecto, HttpStatus.OK);
	}

}
