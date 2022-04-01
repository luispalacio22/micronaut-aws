package TestMicronautGradle.controller;

import TestMicronautGradle.model.Persona;
import TestMicronautGradle.service.PersonaService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

@Controller(value = "/persona")
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Post("/save")
    public String save(@Body Persona persona){
        return personaService.save(persona);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get(value = "/getPerson/{id}")
    public String getPerson(Integer id){
        return personaService.getPerson(id);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get(value = "/getPerson")
    public String getAll(){
        return personaService.getALl();
    }



    @Delete(value = "/delete",produces = {"application/json"})
    public String delete(@Body Persona persona){
        return personaService.delete(persona);
    }
}
