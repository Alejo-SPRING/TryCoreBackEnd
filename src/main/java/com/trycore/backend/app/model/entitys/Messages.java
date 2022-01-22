package com.trycore.backend.app.model.entitys;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Messages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
	private String message;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Planeta.class)
	private Planeta sendFrom;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Planeta.class)
	private Planeta sendTo;

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Planeta getSendFrom() {
		return sendFrom;
	}

	public Planeta getSendTo() {
		return sendTo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSendFrom(Planeta sendFrom) {
		this.sendFrom = sendFrom;
	}

	public void setSendTo(Planeta sendTo) {
		this.sendTo = sendTo;
	}

}
