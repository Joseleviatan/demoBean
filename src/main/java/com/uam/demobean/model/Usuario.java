package com.uam.demobean.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @NotNull(message = "no puede ser null")
    @NotBlank(message = "no puede ir una cadena vacia")
    private String primerNombre;
    @NotNull(message = "no puede ser null")
    @NotBlank(message = "no puede ir una cadena vacia")

    private String segundoNombre;

    private String primerApellido;
    @NotNull(message = "no puede ser null")
    @NotBlank(message = "no puede ir una cadena vacia")

    private String segundoApellido;
    @NotNull(message = "no puede ser null")
    @NotBlank(message = "no puede ir una cadena vacia")

    private String password;

    @Email(message = "Correo no valido")
    private String email;

    @Min(value = 18, message = "La edad no puede ser menor a 18")
    private Integer edad;



}
