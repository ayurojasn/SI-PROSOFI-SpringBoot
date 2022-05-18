package com.javeriana.prosofi.administrador.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
public class Docente {

    @Id
    @GeneratedValue
    @Column(name= "id_docente")
    private Long idDocente;

    @Column(name= "facultad")
    private String facultad;

    @Column(name= "tipo_documento")
    private String tipo_documento;

    @Column(name= "documento")
    private String documento;

    @Column(name= "correo_javeriano")
    private String correo_javeriano;

    @Column(name= "nombre_completo")
    private String nombre_completo;

    @OneToOne
    private Involucrado involucrado;

    public Docente() {
    }

    public Docente(String facultad, String tipo_documento, String documento, String correo_javeriano, String nombre_completo) {
        this.facultad = facultad;
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.correo_javeriano = correo_javeriano;
        this.nombre_completo = nombre_completo;
    }

    public Long getIdDocente() {
        return this.idDocente;
    }

    public void setIdDocente(Long idDocente) {
        this.idDocente = idDocente;
    }

    public String getFacultad() {
        return this.facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getTipo_documento() {
        return this.tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo_javeriano() {
        return this.correo_javeriano;
    }

    public void setCorreo_javeriano(String correo_javeriano) {
        this.correo_javeriano = correo_javeriano;
    }


    public void setInvolucrado(Involucrado involucrado) {
        this.involucrado = involucrado;
    }
  

    @Override
    public String toString() {
        return "{" +
            " idDocente='" + getIdDocente() + "'" +
            ", facultad='" + getFacultad() + "'" +
            ", tipo_documento='" + getTipo_documento() + "'" +
            ", documento='" + getDocumento() + "'" +
            ", correo_javeriano='" + getCorreo_javeriano() + "'" +
            ", involucrado='" + getInvolucrado() + "'" +
            "}";
    }

   


}
