package com.uam.demobean.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Usuario {
    @Id
    // Anotación que especifica la generación automática del valor del identificador
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @NotNull(message = "no puede ser nulo")
    @NotBlank(message = "No puede ir una cadena vacia")
    private String primerNombre;
    @NotNull(message = "no puede ser nulo")
    @NotBlank(message = "No puede ir una cadena vacia")
    private String primerApellido;
    @NotNull(message = "no puede ser nulo")
    @NotBlank(message = "No puede ir una cadena vacia")
    private String segundoNombre;
    @NotNull(message = "no puede ser nulo")
    @NotBlank(message = "No puede ir una cadena vacia")
    private String segundoApellido;
    @NotNull(message = "no puede ser nulo")
    @NotBlank(message = "No puede ir una cadena vacia")
    private String password;

    @Email(message = "correo no valido")
    private String email;

    @Min(value = 18, message = "La edad no puede ser menor a 18")
    private int edad;

}
