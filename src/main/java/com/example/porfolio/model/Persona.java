/* con LOMBOK podemos usar las anotaciones para que de manera
automatica nos cree los setters y getter correspondientes
 */
package com.example.porfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 1, max = 25, message = "campo obligatorio con hasta 50 carácteres")
    private String nombre;
    @NotBlank
    @Size(min = 1, max = 25, message = "campo obligatorio con hasta 50 carácteres")
    private String apellido;
    @NotBlank
    @Size(min = 1, max = 2000, message = "campo obligatorio con hasta 2000 carácteres")
    private String acerca_de;
    private String foto_perfil;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String acerca_de, String foto_perfil) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.acerca_de = acerca_de;
        this.foto_perfil = foto_perfil;
    }

}
