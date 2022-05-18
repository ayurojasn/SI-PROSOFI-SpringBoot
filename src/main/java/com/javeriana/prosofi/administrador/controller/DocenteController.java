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
import com.javeriana.prosofi.administrador.model.Docente;
import com.javeriana.prosofi.administrador.service.DocenteService;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/docente")
public class DocenteController {

	private DocenteService docenteService;

	public DocenteController(final DocenteService docenteService) {

		this.docenteService = docenteService;
	}

	@PostMapping("/addDocente")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Docente> add(@NotNull @RequestBody Docente docente) {

		Docente newDocente = docenteService.addDocente(docente);
		return new ResponseEntity<Docente>(newDocente, HttpStatus.OK);
	}

	@GetMapping("/findAllDocentes")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Docente>> findAll() {

		List<Docente> docentes = docenteService.finaAllDocentes();
		return new ResponseEntity<List<Docente>>(docentes, HttpStatus.OK);
	}

	@GetMapping("/findDocenteById/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Docente> findById(@NotNull @PathVariable Long id) {

		Docente docente = docenteService.findDocente(id).orElse(null);
		return new ResponseEntity<Docente>(docente, HttpStatus.OK);
	}

	@PutMapping("/updateDocente/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Docente> updateById(@NotNull @PathVariable Long id,
													 @NotNull @RequestBody Docente docente) {

		Docente newDocente = docenteService.updateDocente(docente, id);
		return new ResponseEntity<Docente>(newDocente, HttpStatus.OK);
	}
}
