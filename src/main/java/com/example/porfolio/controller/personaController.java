
package com.example.porfolio.controller;

import com.example.porfolio.model.Persona;
import com.example.porfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class personaController {

   @Autowired
   private IPersonaService persoService; 
  
   
   @GetMapping("/lista")
   @ResponseBody
   public List<Persona> verPersonas() {
    return persoService.verPersonas();
}
   
   @PostMapping("/new")
   public String agregarPersona (@RequestBody Persona pers){
       persoService.crearPersona(pers);
       return "La persona fue creada correctamente";       
   }
   
   @DeleteMapping("/borrar/{id}")
   public String borrarPersona (@PathVariable Long id) {
       persoService.borrarPersona(id);
       return "la persona fue eliminada correctamente";
   }
   
   @PutMapping("/editar/{id}")
   public Persona editarPersona(@PathVariable Long id,
                        @RequestParam("nombre") String newNombre,
                        @RequestParam("apellido") String newApellido,
                        @RequestParam("acerca_de") String newAcerca_de,
                        @RequestParam("foto_perfil") String newFoto_Perfil) {
    Persona persona = persoService.buscarPersona(id);
            persona.setNombre(newNombre);
            persona.setApellido(newApellido);
            persona.setAcerca_de(newAcerca_de);
            persona.setFoto_perfil(newFoto_Perfil);
            
            persoService.crearPersona(persona);
            return persona;
   }
  
    
}
