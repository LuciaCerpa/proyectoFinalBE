package com.luciacerpap.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luciacerpap.clinica.utils.GsonProvider;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String apellido;

    @NotBlank
    private String nombre;

    @NotBlank
    @Size(min = 8, max = 15)
    private String dni;

    @NotNull
    private LocalDate fechaIngreso;

    @OneToOne(cascade  = CascadeType.ALL)
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.REMOVE)
    //@JsonManagedReference(value = "paciente-turno")
    @JsonIgnore
    private Set<Turno> turnoSet;

    @Override
    public String toString() {
        return GsonProvider.getGson().toJson(this);
    }
}
