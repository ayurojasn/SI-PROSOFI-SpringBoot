package com.javeriana.prosofi.administrador.model;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Table(name = "entidad")
public class Entidad {
    @Id
    @GeneratedValue
    @Column(name= "id_entidad")
    private Long idEntidad;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "celular")
    private String celular;

    @Column(name= "direccion")
    private String direccion;

    @Column(name= "descripcion")
    private String descripcion;

    @Column(name= "fecha_vinculacion")
    @CreationTimestamp
    private Date fecha_vinculacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="entidad")
    @JsonIgnore
    private List<ResponsableEntidad> responsable_entidad = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="entidad")
    @JsonIgnore
    private List<Proyecto> proyectos = new ArrayList<>();

    public Entidad() {}


    public Entidad(String nombre, String celular, String direccion, String descripcion, Date fecha_vinculacion) {
        this.nombre = nombre;
        this.celular = celular;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.fecha_vinculacion = fecha_vinculacion;
    }

    public Long getIdEntidad() {
        return this.idEntidad;
    }

    public void setIdEntidad(Long idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_vinculacion() {
        return this.fecha_vinculacion;
    }

    public void setFecha_vinculacion(Date fecha_vinculacion) {
        this.fecha_vinculacion = fecha_vinculacion;
    }

    public List<ResponsableEntidad> getResponsable_entidad() {
        return this.responsable_entidad;
    }

    public void setResponsable_entidad(List<ResponsableEntidad> responsable_entidad) {
        this.responsable_entidad = responsable_entidad;
    }

    public List<Proyecto> getProyectos() {
        return this.proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public String toString() {
        return "{" +
            " idEntidad='" + getIdEntidad() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", celular='" + getCelular() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", fecha_vinculacion='" + getFecha_vinculacion() + "'" +
            ", responsable_entidad='" + getResponsable_entidad() + "'" +
            ", proyectos='" + getProyectos() + "'" +
            "}";
    }

    //Add ResponsableEntidad to Entidad
    public void addResponsableEntidad(ResponsableEntidad responsableE){
        this.responsable_entidad.add(responsableE);
    }

    //Add Proyecto to Entidad
    public void addProyecto(Proyecto proyectop){
        this.proyectos.add(proyectop);
    }
}
