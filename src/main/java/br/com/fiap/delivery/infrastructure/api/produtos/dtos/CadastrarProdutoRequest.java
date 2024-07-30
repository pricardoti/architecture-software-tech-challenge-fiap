package br.com.fiap.delivery.infrastructure.api.produtos.dtos;

import br.com.fiap.delivery.domain.produto.CategoriaProduto;
import br.com.fiap.delivery.domain.produto.Produto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class CadastrarProdutoRequest {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String descricao;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private CategoriaProduto categoria;

    private String imagemUrl;

    public Produto toDomain() {
        return new Produto(nome, descricao, preco, categoria, imagemUrl);
    }

    public Produto toDomain(UUID codigoProduto) {
        return new Produto(codigoProduto, nome, descricao, preco, categoria, imagemUrl);
    }
}