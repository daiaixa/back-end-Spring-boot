
package com.example.porfolio.service;

import com.example.porfolio.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    public List <Experiencia> verExperiencia(); 
    public void crearExperiencia (Experiencia exp);
    public void borrarExperiencia (Long id);
    public Experiencia buscarExperiencia (Long id);
     public Experiencia findById(Long id);   
    public boolean existsById(Long id);
}
