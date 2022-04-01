package TestMicronautGradle.service;

import TestMicronautGradle.model.Persona;

public interface PersonaService {
    String save(Persona persona);

    String getPerson(Integer persona);

    String delete(Persona persona);

    String getALl();
}
