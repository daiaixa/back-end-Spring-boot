
package com.example.porfolio.repository;

import com.example.porfolio.model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Long>{

    public Optional<Educacion> findByCurso(String curso);

    public boolean existsByCurso(String curso);
    
}
