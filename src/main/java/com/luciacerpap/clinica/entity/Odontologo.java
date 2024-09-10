package com.luciacerpap.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luciacerpap.clinica.utils.GsonProvider;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "odontologos")
public class Odontologo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String nroMatricula;
    private String apellido;
    private String nombre;

    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.REMOVE)
    //@JsonManagedReference(value = "odontologo-turno")
    @JsonIgnore
    private Set<Turno> turnoSet;

    @Override
    public String toString() {
        return GsonProvider.getGson().toJson(this);
    }
}
