package br.com.delivery.delivery.application.domain.pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class PedidoProduto {
    private UUID codigoProduto;
    private Integer quantidade;
}
