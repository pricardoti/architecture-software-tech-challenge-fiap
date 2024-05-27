package br.com.delivery.delivery.application.ports.outbound.cliente;

import java.util.UUID;

public interface ExcluirClienteOutboundPort {

    void excluir(UUID codigoCliente);
}
