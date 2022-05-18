package com.javeriana.prosofi.administrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javeriana.prosofi.administrador.model.Entidad;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long> {

}
