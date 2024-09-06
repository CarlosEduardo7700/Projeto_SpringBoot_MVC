package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.dto.Disciplina;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("calculadora")
public class CalculadoraController {

    @GetMapping
    public String calculadoraDeMediaFIAP() {
        return "calculadora";
    }

    @PostMapping
    @Transactional
    public String post(Disciplina disciplina, Model model) {
        Double mediaFinal = disciplina.calcularMediaFianl();

        if (mediaFinal >= 6) {
            model.addAttribute("msg", "Você vai se formar!");
        } else {
            model.addAttribute("msg", "Você não vai se formar!");
        }

        model.addAttribute("mediaFinal", mediaFinal);

        return "calculadora";
    }
}
