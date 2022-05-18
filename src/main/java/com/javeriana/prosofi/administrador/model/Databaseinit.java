package com.javeriana.prosofi.administrador.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


import com.javeriana.prosofi.administrador.repository.DocenteRepository;
import com.javeriana.prosofi.administrador.repository.EntidadRepository;
import com.javeriana.prosofi.administrador.repository.InvolucradoRepository;
import com.javeriana.prosofi.administrador.repository.InvolucradoXProyectoRepository;
import com.javeriana.prosofi.administrador.repository.ProyectoRepository;
import com.javeriana.prosofi.administrador.repository.ResponsableEntidadRepository;

import com.javeriana.prosofi.administrador.model.Docente;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Databaseinit implements ApplicationRunner{

    @Autowired
    DocenteRepository docenteRepository;

    @Autowired
    EntidadRepository entidadRepository;

    @Autowired
    InvolucradoRepository involucradoRepository;

    @Autowired
    InvolucradoXProyectoRepository involucradoXProyectoRepository;

    @Autowired
    ProyectoRepository proyectoRepository;

    @Autowired
    ResponsableEntidadRepository responsableEntidadRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        // Creando datos para la base de datos

        Docente d1 = new Docente("Medicina", "C.C", "1000372620", "test@javeriana.edu.co", "Pepito Perez");
        Docente d2 = new Docente("Ingeniería", "C.C", "1000372620", "test@javeriana.edu.co", "Laura Lopez");
        Docente d3 = new Docente("Lenguas", "C.C", "1000372620", "test@javeriana.edu.co", "Felipe Mendez");

        Date today = new Date();
        Entidad e1 = new Entidad("La flora", "3145621718", "Calle 10 #4-50", "Entidad PROSOFI", today);
        Entidad e2 = new Entidad("Test project", "3145621718", "Calle 10 #4-50", "Entidad test", today);

        Involucrado i1 = new Involucrado("C.C", "102938384", "Universidad", "Pablo Cortés","4322345", "3145321234", "test@javeriana.edu.co", "test@hotmail.com", "Asistente", "Ingeniería", "Ingeniería de sistemas", "N/N", today);
        Involucrado i2 = new Involucrado("C.C", "102938384", "Universidad", "Sebastián Morales","4322345", "3145321234", "test@javeriana.edu.co", "test@hotmail.com", "Asistente", "Ingeniería", "Ingeniería de sistemas", "N/N", today);

        Proyecto p1 = new Proyecto("Proyecto 1", "Ayuda con...", "Mejorar...", today, today, "128373838");
        Proyecto p2 = new Proyecto("Proyecto 2", "Ayuda con...", "Mejorar...", today, today, "128373838");

        ResponsableEntidad r1 = new ResponsableEntidad("102929393", "C.C", "Manuel Coral", "3234553", "315762828282", "test@javeriana.edu.co");
        ResponsableEntidad r2 = new ResponsableEntidad("102929393", "C.C", "Jose Rojas", "3234553", "315762828282", "test@javeriana.edu.co");
        ResponsableEntidad r3 = new ResponsableEntidad("102929393", "C.C", "David Durán", "3234553", "315762828282", "test@javeriana.edu.co");

        d1.setInvolucrado(i1);
        d2.setInvolucrado(i2);
        d3.setInvolucrado(i2);
        
        docenteRepository.save(d1);
        docenteRepository.save(d2);
        docenteRepository.save(d3);

        r1.setEntidad(e1);
        r2.setEntidad(e2);
        r3.setEntidad(e1);

        responsableEntidadRepository.save(r1);
        responsableEntidadRepository.save(r2);
        responsableEntidadRepository.save(r3);

        p1.setEntidad(e1);
        p2.setEntidad(e2);
        
        p1.setLider(i1);
        p2.setLider(i2);
     
        proyectoRepository.save(p1);
        proyectoRepository.save(p2);

        i1.setDocente(d1);
        i2.setDocente(d2);

        i1.addProyecto(p1, "Universidad");
        i2.addProyecto(p2, "Universidad");

        involucradoRepository.save(i1);
        involucradoRepository.save(i2);

        e1.addResponsableEntidad(r1);
        e2.addResponsableEntidad(r2);

        e1.addProyecto(p1);
        e2.addProyecto(p2);
    }

}