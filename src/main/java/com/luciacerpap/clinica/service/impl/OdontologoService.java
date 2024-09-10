package com.luciacerpap.clinica.service.impl;

import com.luciacerpap.clinica.dto.request.OdontologoRequestDto;
import com.luciacerpap.clinica.dto.response.OdontologoResponseDto;
import com.luciacerpap.clinica.entity.Odontologo;
import com.luciacerpap.clinica.exception.ResourceNotFoundException;
import com.luciacerpap.clinica.repository.IOdontologoRepository;
import com.luciacerpap.clinica.service.IOdontologoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {
    @Autowired
    private ModelMapper modelMapper;
    private IOdontologoRepository odontologoRepository;

    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<OdontologoResponseDto> buscarPorId(Integer id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if (odontologo.isPresent()) {
            OdontologoResponseDto odontologoResponseDto = modelMapper.map(odontologo.get(), OdontologoResponseDto.class);
            return Optional.of(odontologoResponseDto);
        } else {
            throw new ResourceNotFoundException("Odontologo no encontrado");
        }
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public void modificarOdontologo(OdontologoRequestDto odontologo){
        Optional<OdontologoResponseDto> odontologoAux = buscarPorId(odontologo.getId());
        odontologoRepository.save(modelMapper.map(odontologo, Odontologo.class));
    }

    @Override
    public void eliminarOdontologo(Integer id){
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if(odontologo.isPresent()){
            odontologoRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("Odontologo no encontrado");
        }
    }
}

