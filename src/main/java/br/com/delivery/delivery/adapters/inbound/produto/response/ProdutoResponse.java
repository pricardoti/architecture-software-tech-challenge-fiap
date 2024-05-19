package br.com.delivery.delivery.adapters.inbound.produto.response;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class ProdutoResponse {

    private @NonNull String nome;
    private @NonNull String tipo;
    private @NonNull String descricao;
}
