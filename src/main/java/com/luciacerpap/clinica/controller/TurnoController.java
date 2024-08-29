package com.luciacerpap.clinica.controller;

import com.luciacerpap.clinica.entity.Turno;
import com.luciacerpap.clinica.service.ITurnoService;
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
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.guardarTurno(turno));
    }

    //PUT
    @PutMapping("/modificar")
    public ResponseEntity<String> modificarTurno(@RequestBody Turno turno){
        turnoService.modificarTurno(turno);
        return ResponseEntity.ok("el turno "+ turno.getId() + " fue modificado");
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Integer id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("el turno "+ id + " fue eliminado");
    }

    //GET
    @GetMapping("/buscar/{id}")
    public Optional<Turno> buscarPorId(@PathVariable Integer id){
        return turnoService.buscarPorId(id);
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<List<Turno>> buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

}
