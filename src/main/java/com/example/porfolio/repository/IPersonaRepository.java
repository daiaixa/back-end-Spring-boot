package com.example.porfolio.repository;

import com.example.porfolio.model.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    
    Optional<Persona> findByNombre (String nombre);
    boolean existsByNombre (String nombre);

    public void deleteById(int id);

    public void findById(int id);
    
}
