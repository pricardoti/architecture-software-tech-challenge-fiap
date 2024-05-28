package br.com.delivery.delivery.application.domain.pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public class PedidoProduto {
    private UUID codigoProduto;
    private Integer quantidade;
}
