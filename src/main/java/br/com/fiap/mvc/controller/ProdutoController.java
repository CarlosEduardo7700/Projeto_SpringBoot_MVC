package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.model.Produto;
import br.com.fiap.mvc.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("cadastrar")
    public String cadastrarProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "produto/cadastrar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String post(Produto produto, Model model) {
        repository.save(produto);
        model.addAttribute("msg", "Produto cadastrado!");
        return "produto/cadastrar";
    }

    @GetMapping("listar")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", repository.findAll());
        return "produto/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("produto", repository.findById(id));
        return "produto/editar";
    }
}
