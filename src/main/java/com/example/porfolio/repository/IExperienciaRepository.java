
package com.example.porfolio.repository;

import com.example.porfolio.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long>{
    
    public boolean existsById(Long id);
    
    public Optional<Experiencia> findById(Long id);
}
