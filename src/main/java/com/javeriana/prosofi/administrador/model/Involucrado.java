package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;


@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "involucrado")
public class Involucrado {
    @Id
    @GeneratedValue
    @Column(name= "id_involucrado")
    private Long idInvolucrado;

    @Column(name= "tipo_documento")
    private String tipo_documento;

    @Column(name= "documento", nullable = false)
    private String documento;

    @Column(name= "tipo_involucrado")
    private String tipo_involucrado;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "telefono")
    private String telefono;

    @Column(name= "celular")
    private String celular;

    @Column(name = "correo_javeriano")
    private String correo_javeriano;

    @Column(name= "correo_externo")
    private String correo_externo;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name= "fecha_nacimiento")
    private Date fecha_nacimiento;

    @Column(name= "cargo_administrativo")
    private String cargo_administrativo;

    @Column(name= "facultad")
    private String facultad;

    @Column(name= "carrera")
    private String carrera;

    @Column(name= "organizacion_voluntario")
    private String organizacion_voluntario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "involucrado")
    @JsonIncludeProperties({"idInvolucradoXProyecto"})
    private List<InvolucradoXProyecto> proyectos = new ArrayList<>();

    @OneToOne
    @JsonIgnore
    private Docente docente;

    public Involucrado() {
    }

    public Involucrado(String tipo_documento, String documento, String tipo_involucrado, String nombre, String telefono, String celular, String correo_javeriano,  String correo_externo, String cargo_administrativo, String facultad, String carrera, String organizacion_voluntario, Date fecha_nacimiento) {
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.tipo_involucrado = tipo_involucrado;
        this.nombre = nombre;
        this.telefono = telefono;
        this.celular = celular;
        this.correo_javeriano = correo_javeriano;
        this.correo_externo = correo_externo;
        this.cargo_administrativo = cargo_administrativo;
        this.facultad = facultad;
        this.carrera = carrera;
        this.organizacion_voluntario = organizacion_voluntario;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Long getIdInvolucrado() {
        return this.idInvolucrado;
    }

    public void setIdInvolucrado(Long idInvolucrado) {
        this.idInvolucrado = idInvolucrado;
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

    public String getTipo_involucrado() {
        return this.tipo_involucrado;
    }

    public void setTipo_involucrado(String tipo_involucrado) {
        this.tipo_involucrado = tipo_involucrado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo_javeriano() {
        return this.correo_javeriano;
    }

    public void setCorreo_javeriano(String correo_javeriano) {
        this.correo_javeriano = correo_javeriano;
    }

    public String getCorreo_externo() {
        return this.correo_externo;
    }

    public void setCorreo_externo(String correo_externo) {
        this.correo_externo = correo_externo;
    }

    public Date getFecha_nacimiento() {
        return this.fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCargo_administrativo() {
        return this.cargo_administrativo;
    }

    public void setCargo_administrativo(String cargo_administrativo) {
        this.cargo_administrativo = cargo_administrativo;
    }

    public String getFacultad() {
        return this.facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return this.carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getOrganizacion_voluntario() {
        return this.organizacion_voluntario;
    }

    public void setOrganizacion_voluntario(String organizacion_voluntario) {
        this.organizacion_voluntario = organizacion_voluntario;
    }

    public List<InvolucradoXProyecto> getProyectos() {
        return this.proyectos;
    }

    public void setProyectos(List<InvolucradoXProyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Docente getDocente() {
        return this.docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

 
    @Override
    public String toString() {
        return "{" +
            " idInvolucrado='" + getIdInvolucrado() + "'" +
            ", tipo_documento='" + getTipo_documento() + "'" +
            ", documento='" + getDocumento() + "'" +
            ", tipo_involucrado='" + getTipo_involucrado() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", celular='" + getCelular() + "'" +
            ", correo_javeriano='" + getCorreo_javeriano() + "'" +
            ", correo_externo='" + getCorreo_externo() + "'" +
            ", fecha_nacimiento='" + getFecha_nacimiento() + "'" +
            ", cargo_administrativo='" + getCargo_administrativo() + "'" +
            ", facultad='" + getFacultad() + "'" +
            ", carrera='" + getCarrera() + "'" +
            ", organizacion_voluntario='" + getOrganizacion_voluntario() + "'" +
            ", proyectos='" + getProyectos() + "'" +
            ", docente='" + getDocente() + "'" +
            "}";
    }

    //Add InvolucradoxProyecto to Involucrado
    public void addProyecto(Proyecto proyectop, String forma_vinculacion){
        InvolucradoXProyecto invPro = new InvolucradoXProyecto(proyectop, this, forma_vinculacion);
        this.proyectos.add(invPro);
    }
}
