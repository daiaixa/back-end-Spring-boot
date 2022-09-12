package com.example.porfolio.dto;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducacionDto {

    private String establecimiento;
    private String curso;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;

    public EducacionDto() {
    }

    public EducacionDto(String establecimiento, String curso, String descripcion, Date fecha_inicio, Date fecha_fin) {
        this.establecimiento = establecimiento;
        this.curso = curso;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

}
