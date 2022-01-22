package com.trycore.backend.app.model.entitys;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Planeta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
	private String nombre;
	@Basic
	private Long cantidadHabitantes;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Basic
	private Date periodoDeRotacion;
	@Basic
	private BigDecimal diametro;
	@Basic
	private String clima;
	@Basic
	private String terreno;
	@Basic
	private Long contador;
	@Basic
	private String urlImg;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = PersonaHasPlaneta.class, mappedBy = "planeta")
	private List<PersonaHasPlaneta> planetas;

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public List<PersonaHasPlaneta> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(List<PersonaHasPlaneta> planetas) {
		this.planetas = planetas;
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
