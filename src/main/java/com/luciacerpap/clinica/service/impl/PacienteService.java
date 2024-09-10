package com.luciacerpap.clinica.service.impl;

import com.luciacerpap.clinica.dto.request.PacienteRequestDto;
import com.luciacerpap.clinica.dto.response.PacienteResponseDto;
import com.luciacerpap.clinica.entity.Paciente;
import com.luciacerpap.clinica.exception.ResourceNotFoundException;
import com.luciacerpap.clinica.repository.IPacienteRepository;
import com.luciacerpap.clinica.service.IPacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {
    @Autowired
    private ModelMapper modelMapper;
    private IPacienteRepository pacienteRepository;

    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Optional<PacienteResponseDto> buscarPorId(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isPresent()) {
            PacienteResponseDto pacienteResponseDto = modelMapper.map(paciente.get(), PacienteResponseDto.class);
            return Optional.of(pacienteResponseDto);
        } else {
            throw new ResourceNotFoundException("Paciente no encontrado");
        }
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public void modificarPaciente(PacienteRequestDto paciente) {
        Optional<PacienteResponseDto> pacienteAux = buscarPorId(paciente.getId());
        pacienteRepository.save(modelMapper.map(paciente, Paciente.class));
    }

    @Override
    public void eliminarPaciente(Integer id) {
        Optional<PacienteResponseDto> pacienteEncontrado = buscarPorId(id);
        pacienteRepository.deleteById(id);
    }

    @Override
    public List<Paciente> buscarPorApellidoyNombre(String apellido, String nombre) {
        return pacienteRepository.findByApellidoAndNombre(apellido, nombre);
    }

    @Override
    public List<Paciente> buscarPorUnaParteApellido(String parte){
        return pacienteRepository.buscarPorParteApellido(parte);
    }
}

