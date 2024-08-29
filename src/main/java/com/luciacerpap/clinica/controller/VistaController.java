package com.luciacerpap.clinica.controller;

import com.luciacerpap.clinica.entity.Paciente;
import com.luciacerpap.clinica.service.impl.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class VistaController {

    private PacienteService pacienteService;

    public VistaController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //localhost:8080/index?id=1&nombre=paciente1
    @GetMapping("/index")
    public String buscarPaciente(Model model, @RequestParam Integer id){
      Optional<Paciente> paciente = pacienteService.buscarPorId(id);
        model.addAttribute("nombre", paciente.get().getNombre());
       model.addAttribute("apellido", paciente.get().getApellido());
       return "vista/paciente";
    }
}
