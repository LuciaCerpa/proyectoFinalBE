package com.luciacerpap.clinica.repository;

import com.luciacerpap.clinica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ITurnoRepository extends JpaRepository<Turno, Integer> {

    @Query("Select t from Turno t join t.paciente p with p.apellido = :pacienteApellido ")
    Optional<Turno> buscarPorApellidoPaciente(String pacienteApellido);
}
