
package com.example.porfolio.service;

import com.example.porfolio.model.Educacion;
import com.example.porfolio.model.Experiencia;
import java.util.List;
import java.util.Optional;


public interface IEducacionService {
    
    Optional<Educacion> findByCurso(String curso);
    boolean existsByCurso(String curso);
    boolean existsById(Long id);
    
    public List <Educacion> verEducacion(); 
    public void crearEducacion (Educacion edu);
    public void borrarEducacion (Long id);
    public Educacion buscarEducacion (Long id);
    
   
    
}
