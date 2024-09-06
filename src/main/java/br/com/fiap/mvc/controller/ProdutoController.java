package br.com.fiap.mvc.controller;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @GetMapping("cadastrar")
    public String cadastrarProduto() {
        return "produto/form_cadastro";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String post(String nome, Double valor, Model model) {
        model.addAttribute("nome", nome);
        model.addAttribute("valor", valor);
        model.addAttribute("msg", "Produto cadastrado!");
        return "produto/form_cadastro";
    }
}
