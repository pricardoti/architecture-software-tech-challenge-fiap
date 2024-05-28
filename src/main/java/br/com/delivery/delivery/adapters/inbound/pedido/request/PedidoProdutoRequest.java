package br.com.delivery.delivery.adapters.inbound.pedido.request;

import br.com.delivery.delivery.application.domain.pedido.PedidoProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoProdutoRequest {

    private static final int TAMANHO_CODIGO_PRODUTO = 36;

    @NotBlank
    @Size(min = TAMANHO_CODIGO_PRODUTO, max = TAMANHO_CODIGO_PRODUTO)
    private String codigoProduto;

    @NotNull
    private Integer quantidade;

    public PedidoProduto toDomain() {
        return new PedidoProduto(UUID.fromString(codigoProduto), quantidade);
    }
}