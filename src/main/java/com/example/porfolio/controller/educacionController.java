package com.example.porfolio.controller;

import com.example.porfolio.dto.EducacionDto;
import com.example.porfolio.dto.Mensaje;
import com.example.porfolio.model.Educacion;
import com.example.porfolio.service.IEducacionService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "*")
public class educacionController {

    @Autowired
    public IEducacionService eduService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> verListaEdu() {
     List<Educacion> list = eduService.verEducacion();
     return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarEducacion (@PathVariable("id") Long id){
        if(!eduService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        eduService.borrarEducacion(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    }
    


    @PostMapping("/new")
    public ResponseEntity<?> guardarEdu(@RequestBody EducacionDto dtoedu) {

        if (eduService.existsByCurso(dtoedu.getCurso())) {
            return new ResponseEntity(new Mensaje("El curso ya existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(
                dtoedu.getEstablecimiento(), dtoedu.getCurso(), dtoedu.getDescripcion(),
                dtoedu.getFecha_inicio(), dtoedu.getFecha_fin()
        );
        eduService.crearEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educación creada"), HttpStatus.OK);
    }
    
 
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editEducacion(@PathVariable("id") Long id, @RequestBody EducacionDto dtoedu){
        if(!eduService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(eduService.existsByCurso(dtoedu.getCurso()) && eduService.findByCurso(dtoedu.getCurso()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Intentas actualizar un curso que ya existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = eduService.buscarEducacion(id);
        
        educacion.setEstablecimiento(dtoedu.getEstablecimiento());
        educacion.setCurso(dtoedu.getCurso());
        educacion.setDescripcion(dtoedu.getDescripcion());
        educacion.setFecha_inicio(dtoedu.getFecha_inicio());
        educacion.setFecha_fin(dtoedu.getFecha_fin());
        
        eduService.crearEducacion(educacion);
        
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
    }
    
    
    //no lo implemetaré en el Front pero lo dejo a modo de completar el CRUD del backend
        @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")Long id){
        if(!eduService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }        
        Educacion educacion = eduService.buscarEducacion(id);
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
}
