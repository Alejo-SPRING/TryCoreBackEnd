package com.trycore.backend.app.pojos;

import java.util.ArrayList;
import java.util.List;

import com.trycore.backend.app.model.entitys.PersonaHasPlaneta;
import com.trycore.backend.app.model.entitys.Planeta;

public class PlanetaAndPersonasPojo extends PlanetaPojo {

	private List<PersonaPojo> personas;

	public PlanetaAndPersonasPojo(Planeta planeta) {
		super(planeta);
		personas = new ArrayList<>();
		if(planeta.getPlanetas() != null) {
			for (PersonaHasPlaneta persona : planeta.getPlanetas()) {
				this.personas.add(new PersonaPojo(persona.getPersona()));
			}
		}
	}

	public List<PersonaPojo> getPersonas() {
		return personas;
	}

	public void setPersonas(List<PersonaPojo> personas) {
		this.personas = personas;
	}

}
