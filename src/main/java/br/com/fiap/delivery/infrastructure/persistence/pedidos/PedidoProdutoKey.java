package br.com.fiap.delivery.infrastructure.persistence.pedidos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PedidoProdutoKey implements Serializable {

    private UUID codigoPedido;
    private UUID codigoProduto;
}