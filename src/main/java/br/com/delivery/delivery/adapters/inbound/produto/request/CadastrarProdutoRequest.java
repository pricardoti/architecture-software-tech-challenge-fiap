package br.com.delivery.delivery.adapters.inbound.produto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class CadastrarProdutoRequest {

    @NotNull
    private String nome;

    @NotNull
    private String tipo;

    @NotNull
    private String descricao;
}
