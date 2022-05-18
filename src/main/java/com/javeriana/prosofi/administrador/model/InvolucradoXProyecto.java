package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class InvolucradoXProyecto {
    @Id
    @GeneratedValue
    @Column(name= "id_involucrado_por_proyecto")
    private Long idInvolucradoXProyecto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proyecto")
    private Proyecto proyecto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "involucrado")
    private Involucrado involucrado;

    @Column(name= "forma_vinculacion")
    private String forma_vinculacion;

    public InvolucradoXProyecto() {
    }

    public InvolucradoXProyecto(Proyecto proyecto, Involucrado involucrado, String forma_vinculacion) {
        this.proyecto = proyecto;
        this.involucrado = involucrado;
        this.forma_vinculacion = forma_vinculacion;
    }

    public Long getIdInvolucradoXProyecto() {
        return this.idInvolucradoXProyecto;
    }

    public void setIdInvolucradoXProyecto(Long idInvolucradoXProyecto) {
        this.idInvolucradoXProyecto = idInvolucradoXProyecto;
    }

    public Proyecto getProyecto() {
        return this.proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Involucrado getInvolucrado() {
        return this.involucrado;
    }

    public void setInvolucrado(Involucrado involucrado) {
        this.involucrado = involucrado;
    }

    public String getForma_vinculacion() {
        return this.forma_vinculacion;
    }

    public void setForma_vinculacion(String forma_vinculacion) {
        this.forma_vinculacion = forma_vinculacion;
    }

    @Override
    public String toString() {
        return "{" +
            " idInvolucradoXProyecto='" + getIdInvolucradoXProyecto() + "'" +
            ", proyecto='" + getProyecto() + "'" +
            ", involucrado='" + getInvolucrado() + "'" +
            ", forma_vinculacion='" + getForma_vinculacion() + "'" +
            "}";
    }



}
