package br.com.delivery.delivery.application.domain.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter(onMethod = @__(@JsonProperty))
@Accessors(fluent = true)
@AllArgsConstructor
public class PedidoProduto {
    private UUID codigoProduto;
    private Integer quantidade;
}
