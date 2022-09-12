/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.porfolio.dto;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienciaDto {

    private String categoria;
    private String puesto;
    private String descripcion;
    private String referencia;
    private String tel_refe;
    private Date fecha_inicio;
    private Date fecha_fin;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String categoria, String puesto, String descripcion, String referencia, String tel_refe, Date fecha_inicio, Date fecha_fin) {
        this.categoria = categoria;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.referencia = referencia;
        this.tel_refe = tel_refe;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    
    
}
