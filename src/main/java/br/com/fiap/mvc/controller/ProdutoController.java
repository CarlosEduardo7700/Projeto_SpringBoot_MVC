package br.com.fiap.mvc.controller;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
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
    public String post(String nome, Double valor) {
        System.out.println(nome + " " + valor);
        return "produto/form_cadastro";
    }
}
