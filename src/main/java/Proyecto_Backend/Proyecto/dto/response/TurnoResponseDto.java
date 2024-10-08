package Proyecto_Backend.Proyecto.dto.response;

import Proyecto_Backend.Proyecto.utils.GsonProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnoResponseDto {
    private Integer id;
    // datos del paciente
    private PacienteResponseDto pacienteResponseDto;
    // datos del odontologo
    private OdontologoResponseDto odontologoResponseDto;
    private String fecha;
    @Override
    public String toString() {
        return GsonProvider.getGson().toJson(this);
    }
}
