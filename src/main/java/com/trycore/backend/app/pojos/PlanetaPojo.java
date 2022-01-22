package com.trycore.backend.app.pojos;

import java.math.BigDecimal;
import java.util.Date;

import com.trycore.backend.app.model.entitys.Planeta;

public class PlanetaPojo {

	private Long id;
	private String nombre;
	private Long cantidadHabitantes;
	private Date periodoDeRotacion;
	private BigDecimal diametro;
	private String clima;
	private String terreno;
	private Long contador;
	private String imgUrl;

	public PlanetaPojo(Planeta planeta) {
		this.id = planeta.getId();
		this.nombre = planeta.getNombre();
		this.cantidadHabitantes = planeta.getCantidadHabitantes();
		this.periodoDeRotacion = planeta.getPeriodoDeRotacion();
		this.diametro = planeta.getDiametro();
		this.clima = planeta.getClima();
		this.terreno = planeta.getTerreno();
		this.contador = planeta.getContador();
		this.imgUrl = planeta.getUrlImg();
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCantidadHabitantes() {
		return cantidadHabitantes;
	}

	public void setCantidadHabitantes(Long cantidadHabitantes) {
		this.cantidadHabitantes = cantidadHabitantes;
	}

	public Date getPeriodoDeRotacion() {
		return periodoDeRotacion;
	}

	public void setPeriodoDeRotacion(Date periodoDeRotacion) {
		this.periodoDeRotacion = periodoDeRotacion;
	}

	public BigDecimal getDiametro() {
		return diametro;
	}

	public void setDiametro(BigDecimal diametro) {
		this.diametro = diametro;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Long getContador() {
		return contador;
	}

	public void setContador(Long contador) {
		this.contador = contador;
	}

}
