package com.trycore.backend.app.enums;

public enum Mensajes {

	PERSONA_NO_ENCONTRADA("¡La persona no se encontro en nuestros registros!"),
	PERSONA_ACTUALIZADA("¡La persona fue actualizado!"),
	PLANETA_NO_ENCONTRADO("¡El planeta no se encontro en nuestros registros!"),
	PLANETA_ACTUALIZADO("¡El planeta fue actualizado!");
	
	private String mensaje;

	private Mensajes(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
