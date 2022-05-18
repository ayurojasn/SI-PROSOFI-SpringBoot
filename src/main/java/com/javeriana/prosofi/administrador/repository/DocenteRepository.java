package com.javeriana.prosofi.administrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javeriana.prosofi.administrador.model.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

}
