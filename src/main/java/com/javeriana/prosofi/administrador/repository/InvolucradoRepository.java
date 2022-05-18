package com.javeriana.prosofi.administrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import com.javeriana.prosofi.administrador.model.Involucrado;

@Repository
public interface InvolucradoRepository extends JpaRepository<Involucrado, Long> {

}
