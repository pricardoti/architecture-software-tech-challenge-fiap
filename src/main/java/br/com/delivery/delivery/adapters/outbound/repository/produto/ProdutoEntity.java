package br.com.delivery.delivery.adapters.outbound.repository.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Accessors(fluent = true)
@Table(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private String descricao;
    private String comentario;

    public static ProdutoEntity from(Produto produto) {
        var produtoEntity = new ProdutoEntity();
        produtoEntity.nome(produto.nome());
        produtoEntity.tipo(produto.tipo());
        produtoEntity.descricao(produto.descricao());
        produtoEntity.comentario(produto.comentario());

        return produtoEntity;
    }
}