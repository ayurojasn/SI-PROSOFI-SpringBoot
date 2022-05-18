package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @GeneratedValue
    @Column(name= "id_proyecto")
    private Long idProyecto;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "descripcion")
    private String descripcion;

    @Column(name= "objetivos")
    private String objetivos;

    @Column(name= "fecha_inicio")
    @CreationTimestamp
    private Date fecha_inicio;

    @Column(name= "fecha_fin")
    private Date fecha_fin;

    @Column(name= "documento_lider")
    private String documento_lider;

    @ManyToOne(cascade = CascadeType.ALL)
    private Entidad entidad;

    @OneToOne(cascade = CascadeType.ALL)
    private Involucrado lider;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="proyecto")
    @JsonIgnore
    private List<InvolucradoXProyecto> involucrados;

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String objetivos, Date fecha_inicio, Date fecha_fin, String documento_lider) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.objetivos = objetivos;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.documento_lider = documento_lider;
    }

    public Long getIdProyecto() {
        return this.idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetivos() {
        return this.objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public Date getFecha_inicio() {
        return this.fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return this.fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDocumento_lider() {
        return this.documento_lider;
    }

    public void setDocumento_lider(String documento_lider) {
        this.documento_lider = documento_lider;
    }

    public Entidad getEntidad() {
        return this.entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public Involucrado getLider() {
        return this.lider;
    }

    public void setLider(Involucrado lider) {
        this.lider = lider;
    }

    public List<InvolucradoXProyecto> getInvolucrados() {
        return this.involucrados;
    }

    public void setInvolucrados(List<InvolucradoXProyecto> involucrados) {
        this.involucrados = involucrados;
    }

    @Override
    public String toString() {
        return "{" +
            " idProyecto='" + getIdProyecto() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", objetivos='" + getObjetivos() + "'" +
            ", fecha_inicio='" + getFecha_inicio() + "'" +
            ", fecha_fin='" + getFecha_fin() + "'" +
            ", documento_lider='" + getDocumento_lider() + "'" +
            ", entidad='" + getEntidad() + "'" +
            ", lider='" + getLider() + "'" +
            ", involucrados='" + getInvolucrados() + "'" +
            "}";
    }

    //Add InvolucradoxProyecto to IProyecto
    public void addInvolucrado(Involucrado involucradoP, String forma_vinculacion){
        InvolucradoXProyecto invPro = new InvolucradoXProyecto(this, involucradoP, forma_vinculacion);
        System.out.println("--------------------------------------------------");
        System.out.println(invPro);
        System.out.println("--------------------------------------------------");

        this.involucrados.add(invPro);
    }
  
}
