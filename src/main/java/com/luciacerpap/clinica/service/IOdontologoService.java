package com.luciacerpap.clinica.service;

import com.luciacerpap.clinica.dto.request.OdontologoRequestDto;
import com.luciacerpap.clinica.dto.response.OdontologoResponseDto;
import com.luciacerpap.clinica.entity.Odontologo;
import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    Odontologo guardarOdontologo(Odontologo odontologo);

    Optional<OdontologoResponseDto> buscarPorId(Integer id);

    List<Odontologo> buscarTodos();

    void modificarOdontologo(OdontologoRequestDto odontologo);

    void eliminarOdontologo(Integer id);

}
