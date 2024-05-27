package br.com.delivery.delivery.adapters.inbound.produto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CadastrarProdutoResponse {

    private @NonNull String codigoProduto;

    public static CadastrarProdutoResponse from(UUID codigoProduto) {
        return new CadastrarProdutoResponse(codigoProduto.toString());
    }
}
