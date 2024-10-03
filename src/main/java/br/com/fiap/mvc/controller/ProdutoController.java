package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.model.Produto;
import br.com.fiap.mvc.model.StatusProduto;
import br.com.fiap.mvc.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("cadastrar")
    public String cadastrarProduto(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("status", StatusProduto.values());
        return "produto/cadastrar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String post(Produto produto, RedirectAttributes redirectAttributes) {
        repository.save(produto);
        redirectAttributes.addFlashAttribute("msg", "Produto cadastrado!");
        return "redirect:/produto/cadastrar";
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

    @PostMapping("editar")
    public String update(Produto produto, RedirectAttributes redirectAttributes) {
        repository.save(produto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto Atualizado!");
        return "redirect:/produto/listar";
    }

    @PostMapping("deletar")
    @Transactional
    public String deletar(Long id, RedirectAttributes redirectAttributes) {
        repository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Produto Deletado!");
        return "redirect:/produto/listar";
    }
}
