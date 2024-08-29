package com.luciacerpap.clinica.repository;

import com.luciacerpap.clinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
}
