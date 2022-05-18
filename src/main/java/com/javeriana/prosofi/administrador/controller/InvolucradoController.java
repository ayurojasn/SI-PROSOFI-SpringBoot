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
import com.javeriana.prosofi.administrador.model.Involucrado;
import com.javeriana.prosofi.administrador.service.InvolucradoService;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/involucrado")
public class InvolucradoController {

	private InvolucradoService involucradoService;

	public InvolucradoController(final InvolucradoService involucradoService) {

		this.involucradoService = involucradoService;
	}

	@PostMapping("/addInvolucrado")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Involucrado> add(@NotNull @RequestBody Involucrado involucrado) {

		Involucrado newInvolucrado = involucradoService.addInvolucrado(involucrado);
		return new ResponseEntity<Involucrado>(newInvolucrado, HttpStatus.OK);
	}

	@GetMapping("/findAllInvolucrados")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Involucrado>> findAll() {

		List<Involucrado> involucrados = involucradoService.finaAllInvolucrados();
		return new ResponseEntity<List<Involucrado>>(involucrados, HttpStatus.OK);
	}

	@GetMapping("/findInvolucradoById/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Involucrado> findById(@NotNull @PathVariable Long id) {

		Involucrado involucrado = involucradoService.findInvolucrado(id).orElse(null);
		return new ResponseEntity<Involucrado>(involucrado, HttpStatus.OK);
	}

	@PutMapping("/updateInvolucrado/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Involucrado> updateById(@NotNull @PathVariable Long id,
													 @NotNull @RequestBody Involucrado involucrado) {

		Involucrado newInvolucrado = involucradoService.updateInvolucrado(involucrado, id);
		return new ResponseEntity<Involucrado>(newInvolucrado, HttpStatus.OK);
	}
}
