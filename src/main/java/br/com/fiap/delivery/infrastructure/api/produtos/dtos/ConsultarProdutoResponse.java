package br.com.fiap.delivery.infrastructure.api.produtos.dtos;

import br.com.fiap.delivery.domain.produto.CategoriaProduto;
import br.com.fiap.delivery.domain.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ConsultarProdutoResponse {

    private UUID codigo;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private CategoriaProduto categoria;
    private String imagemUrl;

    public ConsultarProdutoResponse(Produto produto) {
        this(
                produto.getCodigo(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getCategoria(),
                produto.getImagemUrl()
        );
    }
}