package com.luciacerpap.clinica.controller;

import com.luciacerpap.clinica.dto.request.TurnoModifyDto;
import com.luciacerpap.clinica.dto.request.TurnoRequestDto;
import com.luciacerpap.clinica.dto.response.TurnoResponseDto;
import com.luciacerpap.clinica.entity.Turno;
import com.luciacerpap.clinica.service.ITurnoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    private ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<TurnoResponseDto> guardarTurno(@Valid @RequestBody TurnoRequestDto turnoRequestDto){
        return ResponseEntity.ok(turnoService.guardarTurno(turnoRequestDto));
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificarTurno(@Valid @RequestBody TurnoModifyDto turnoModifyDto){
        turnoService.modificarTurnos(turnoModifyDto);
        return ResponseEntity.ok("{\"mensaje\": \"El turno fue modificado\"}");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Integer id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("el turno "+ id + " fue eliminado");
    }

    @GetMapping("/buscar/{id}")
    public Optional<TurnoResponseDto> buscarPorId(@PathVariable Integer id){
        return turnoService.buscarPorId(id);
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<List<TurnoResponseDto>> buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @GetMapping("/buscarTurnoApellido/{apellido}")
    public ResponseEntity<TurnoResponseDto> buscarTurnoPorApellido(@PathVariable String apellido){
        Optional<TurnoResponseDto> turno = turnoService.buscarTurnosPorPaciente(apellido);
        return ResponseEntity.ok(turno.get());
    }

}
