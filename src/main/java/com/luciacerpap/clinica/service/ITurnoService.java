package com.luciacerpap.clinica.service;

import com.luciacerpap.clinica.dto.request.TurnoModifyDto;
import com.luciacerpap.clinica.dto.request.TurnoRequestDto;
import com.luciacerpap.clinica.dto.response.TurnoResponseDto;
import com.luciacerpap.clinica.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {

    TurnoResponseDto guardarTurno(TurnoRequestDto turnoRequestDto);

    Optional<TurnoResponseDto> buscarPorId(Integer id);

    List<TurnoResponseDto> buscarTodos();

    void modificarTurnos(TurnoModifyDto turnoModifyDto);

    void eliminarTurno(Integer id);

    Optional<TurnoResponseDto> buscarTurnosPorPaciente(String pacienteApellido);

}
