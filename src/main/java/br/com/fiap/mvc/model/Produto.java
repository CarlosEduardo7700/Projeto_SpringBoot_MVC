package br.com.fiap.mvc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "JA_PRODUTO")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NM_PRODUTO", length = 200, nullable = false)
    private String nome;

    @Column(name = "VL_PRODUTO", nullable = false)
    private Double valor;

    @Column(name = "DS_PRODUTO", length = 500, nullable = false)
    private String descricao;

    @Column(name = "DT_FABRICACAO", nullable = false)
    private LocalDate dataDeFabricacao;

    @Column(name = "ST_NOVO", nullable = false)
    private Boolean novo;

    @Column(name = "STATUS_PRODUTO", nullable = false)
    private StatusProduto status;

}
