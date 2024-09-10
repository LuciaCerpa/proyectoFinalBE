package com.luciacerpap.clinica.repository;

import com.luciacerpap.clinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
    List<Paciente> findByApellidoAndNombre(String apellido, String nombre);

    @Query("Select p from Paciente p where LOWER(p.apellido) LIKE LOWER(CONCAT('%',:parteApellido,'%'))")
    List<Paciente> buscarPorParteApellido(String parteApellido);

}
