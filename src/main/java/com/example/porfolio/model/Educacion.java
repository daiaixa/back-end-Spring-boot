
package com.example.porfolio.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String establecimiento;
    private String curso;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;

    public Educacion() {
    }

    public Educacion(String establecimiento, String curso, String descripcion, Date fecha_inicio, Date fecha_fin) {
        this.establecimiento = establecimiento;
        this.curso = curso;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    
}
