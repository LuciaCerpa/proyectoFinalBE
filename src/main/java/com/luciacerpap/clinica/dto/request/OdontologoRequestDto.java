package com.luciacerpap.clinica.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OdontologoRequestDto {
    private Integer id;
    private String nroMatricula;
    private String apellido;
    private String nombre;
}
