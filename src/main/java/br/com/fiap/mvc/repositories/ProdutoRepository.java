package br.com.fiap.mvc.repositories;

import br.com.fiap.mvc.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
