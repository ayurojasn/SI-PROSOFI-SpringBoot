package com.javeriana.prosofi.administrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.javeriana.prosofi.administrador.model.InvolucradoXProyecto;
import com.javeriana.prosofi.administrador.model.Proyecto;

@Repository
public interface InvolucradoXProyectoRepository extends JpaRepository<InvolucradoXProyecto, Long> {

	@Query(value = "SELECT * FROM INVOLUCRADOXPROYECTO where proyecto = ?1", nativeQuery = true)
	List<InvolucradoXProyecto> findByProyectoId(Long proyectoId);

	@Query(value = "SELECT * FROM INVOLUCRADOXPROYECTO where involucrado = ?1", nativeQuery = true)
	List<InvolucradoXProyecto> findByInvolucradoId(Long involucradoId);
}
