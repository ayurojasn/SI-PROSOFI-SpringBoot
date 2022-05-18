package com.javeriana.prosofi.administrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Table(name = "responsable_entidad")
public class ResponsableEntidad {

	@Id
	@GeneratedValue
	@Column(name = "id_responsable_entidad")
	private Long idResponsableEntidad;

	@Column(name = "documento", nullable = false)
	private String documento;

	@Column(name= "tipo_documento")
	private String tipo_documento;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "celular")
	private String celular;

	@Column(name = "correo")
	private String correo;

	@ManyToOne(cascade = CascadeType.ALL)
	private Entidad entidad;


	public ResponsableEntidad() {
	}

	public ResponsableEntidad(String documento, String tipo_documento, String nombre, String telefono, String celular, String correo) {
		this.documento = documento;
		this.tipo_documento = tipo_documento;
		this.nombre = nombre;
		this.telefono = telefono;
		this.celular = celular;
		this.correo = correo;
	}

	public Long getIdResponsableEntidad() {
		return this.idResponsableEntidad;
	}

	public void setIdResponsableEntidad(Long idResponsableEntidad) {
		this.idResponsableEntidad = idResponsableEntidad;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipo_documento() {
		return this.tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
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

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Entidad getEntidad() {
		return this.entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}


	@Override
	public String toString() {
		return "{" +
			" idResponsableEntidad='" + getIdResponsableEntidad() + "'" +
			", documento='" + getDocumento() + "'" +
			", tipo_documento='" + getTipo_documento() + "'" +
			", nombre='" + getNombre() + "'" +
			", telefono='" + getTelefono() + "'" +
			", celular='" + getCelular() + "'" +
			", correo='" + getCorreo() + "'" +
			", entidad='" + getEntidad() + "'" +
			"}";
	}

}
