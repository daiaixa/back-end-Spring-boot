/* Esta clase sera quien implemente la interfaz
completando los metodos ya declarados en la interfaz
 */
package com.example.porfolio.service;

import com.example.porfolio.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.porfolio.repository.IPersonaRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService implements IPersonaService{
    

    @Autowired 
    public IPersonaRepository persoRepo;

    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll(); 
    }       
        
    @Override
    public void crearPersona(Persona pers) {
        persoRepo.save(pers);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }
        
    @Override
    public Persona buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null); /*si no encuentra la persona
        devuelve un NULL */
    }
    
    public Optional <Persona> getByNombre (String nombre) {
        return persoRepo.findByNombre(nombre);
    }
    
    public boolean existByNombre(String nombre) {
       return persoRepo.existsByNombre(nombre);
    }
    
   
}
