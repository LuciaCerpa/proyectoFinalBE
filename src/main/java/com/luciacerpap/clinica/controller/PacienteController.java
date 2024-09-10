package com.luciacerpap.clinica.controller;

import com.luciacerpap.clinica.dto.request.PacienteRequestDto;
import com.luciacerpap.clinica.dto.response.PacienteResponseDto;
import com.luciacerpap.clinica.entity.Paciente;
import com.luciacerpap.clinica.service.IPacienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //POST
    @PostMapping("/guardar")
    public ResponseEntity<Paciente> guardarPaciente(@Valid @RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    //PUT
    @PutMapping("/modificar")
    public ResponseEntity<String>  modificarPaciente(@RequestBody PacienteRequestDto paciente){
            pacienteService.modificarPaciente(paciente);
            String jsonResponse = "{\"mensaje\": \"El paciente fue modificado\"}";
            return ResponseEntity.ok(jsonResponse);
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Integer id){
             pacienteService.eliminarPaciente(id);
            String jsonResponse = "{\"mensaje\": \"El paciente fue eliminado\"}";
            return ResponseEntity.ok(jsonResponse);
    }

    //GET
    @GetMapping("/buscar/{id}")
    public Optional<PacienteResponseDto>  buscarPorId(@PathVariable Integer id){
        return pacienteService.buscarPorId(id);
    }

    //GET
    @GetMapping("/buscartodos")
    public ResponseEntity<List<Paciente>>  buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }


    @GetMapping("/buscarApellido/{parte}")
    public ResponseEntity<List<Paciente>> buscarParteApellido(@PathVariable String parte){
        return ResponseEntity.ok(pacienteService.buscarPorUnaParteApellido(parte));
    }
}