package com.example.porfolio.controller;

import com.example.porfolio.dto.ExperienciaDto;
import com.example.porfolio.dto.Mensaje;

import com.example.porfolio.model.Experiencia;
import com.example.porfolio.service.IExperienciaService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "*")
public class experienciaController {

    @Autowired
    public IExperienciaService expService;

    @GetMapping("/lista") //funciona correctamente para traer los elementos
    @ResponseBody
    public List<Experiencia> verListaExp() {
        return expService.verExperiencia();
    }

    @PostMapping("/new")
    public ResponseEntity<?> guardarEdu(@RequestBody ExperienciaDto dtoexp) {

        Experiencia experiencia = new Experiencia(
                dtoexp.getCategoria(), dtoexp.getPuesto(), dtoexp.getDescripcion(),
                dtoexp.getReferencia(), dtoexp.getTel_refe(),
                dtoexp.getFecha_inicio(), dtoexp.getFecha_fin());

        expService.crearExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editExperiencia(@PathVariable("id") Long id, @RequestBody ExperienciaDto dtoexp) {
        if (!expService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        Experiencia experiencia = expService.buscarExperiencia(id);

        experiencia.setCategoria(dtoexp.getCategoria());
        experiencia.setPuesto(dtoexp.getPuesto());
        experiencia.setDescripcion(dtoexp.getDescripcion());
        experiencia.setReferencia(dtoexp.getReferencia());
        experiencia.setTel_refe(dtoexp.getTel_refe());
        experiencia.setFecha_inicio(dtoexp.getFecha_inicio());
        experiencia.setFecha_fin(dtoexp.getFecha_fin());

        expService.crearExperiencia(experiencia);

        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarExperiencia(@PathVariable("id") Long id) {
        if (!expService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        expService.borrarExperiencia(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id) {
        if (!expService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = expService.buscarExperiencia(id);
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

}
