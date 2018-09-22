package com.test.business.dto;

import java.util.Date;

public class JuegoDTO {

	private Integer id;
	private String nombre;
	private Integer numCds;
	private String clase;
	private String genero;
	private String subgenero;
	private String localizacion;
	private String valoracion;
	private String comentario;
	private Date fecha;
	private Boolean borrable;
	private Long tamano_instalable;
	private Long tamano_instalado;

	public JuegoDTO() {}

	
	public JuegoDTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public JuegoDTO(Integer id, String nombre, Integer numCds, String clase, String genero, String subgenero, String localizacion,
			String valoracion, String comentario, Date fecha, Boolean borrable, Long tamano_instalable,
			Long tamano_instalado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numCds = numCds;
		this.clase = clase;
		this.genero = genero;
		this.subgenero = subgenero;
		this.localizacion = localizacion;
		this.valoracion = valoracion;
		this.comentario = comentario;
		this.fecha = fecha;
		this.borrable = borrable;
		this.tamano_instalable = tamano_instalable;
		this.tamano_instalado = tamano_instalado;
	}

	public String getClase() {
		return clase;
	}


	public void setClase(String clase) {
		this.clase = clase;
	}


	public Boolean getBorrable() {
		return borrable;
	}


	public void setTamano_instalado(Long tamano_instalado) {
		this.tamano_instalado = tamano_instalado;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumCds() {
		return numCds;
	}

	public void setNumCds(Integer numCds) {
		this.numCds = numCds;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSubgenero() {
		return subgenero;
	}

	public void setSubgenero(String subgenero) {
		this.subgenero = subgenero;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean isBorrable() {
		return borrable;
	}

	public void setBorrable(Boolean borrable) {
		this.borrable = borrable;
	}

	public Long getTamano_instalable() {
		return tamano_instalable;
	}

	public void setTamano_instalable(Long tamano_instalable) {
		this.tamano_instalable = tamano_instalable;
	}

	public Long getTamano_instalado() {
		return tamano_instalado;
	}

}
