package br.com.delivery.delivery.adapters.inbound.produto.response;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "from")
public class CadastrarProdutoResponse {

    private @NonNull String idProduto;
}
