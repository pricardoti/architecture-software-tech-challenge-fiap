package br.com.delivery.delivery.adapters.inbound.produto.request;

import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;
import br.com.delivery.delivery.application.domain.produto.Produto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

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

    public Produto convertToProductDomain() {
        return new Produto(nome, descricao, preco, categoria, imagemUrl);
    }
}
