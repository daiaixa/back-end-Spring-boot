
package com.example.porfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDto {
    
    private String nombre;
    private String apellido;
    private String acerca_de;
    private String foto_perfil;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String acerca_de, String foto_perfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.acerca_de = acerca_de;
        this.foto_perfil = foto_perfil;
    }
    
    
}
