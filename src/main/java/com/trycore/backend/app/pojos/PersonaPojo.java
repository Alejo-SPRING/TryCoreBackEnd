package com.trycore.backend.app.pojos;

import java.math.BigDecimal;
import java.util.Date;

import com.trycore.backend.app.model.entitys.Persona;
import com.trycore.backend.app.model.entitys.Planeta;

public class PersonaPojo {

	private Long id;
	private String nombre;
	private String apellido;
	private Integer edad;
	private BigDecimal altura;
	private BigDecimal peso;
	private String genero;
	private Date fechaNacimiento;
	private Long contador;
	private PlanetaPojo planeta;

	public PersonaPojo(Persona persona, Planeta planeta) {
		this.id = persona.getId();
		this.nombre = persona.getNombre();
		this.apellido = persona.getApellido();
		this.edad = persona.getEdad();
		this.altura = persona.getAltura();
		this.peso = persona.getPeso();
		this.genero = persona.getGenero();
		this.fechaNacimiento = persona.getFechaNacimiento();
		this.contador = persona.getContador();
		this.planeta = new PlanetaPojo(planeta);
	}

	public PersonaPojo(Persona persona) {
		this.id = persona.getId();
		this.nombre = persona.getNombre();
		this.apellido = persona.getApellido();
		this.edad = persona.getEdad();
		this.altura = persona.getAltura();
		this.peso = persona.getPeso();
		this.genero = persona.getGenero();
		this.fechaNacimiento = persona.getFechaNacimiento();
		this.contador = persona.getContador();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getContador() {
		return contador;
	}

	public void setContador(Long contador) {
		this.contador = contador;
	}

	public PlanetaPojo getPlaneta() {
		return planeta;
	}

	public void setPlaneta(PlanetaPojo planeta) {
		this.planeta = planeta;
	}

}
