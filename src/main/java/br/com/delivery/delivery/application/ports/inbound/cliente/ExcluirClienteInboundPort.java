package br.com.delivery.delivery.application.ports.inbound.cliente;

import java.util.UUID;

public interface ExcluirClienteInboundPort {

    void excluir(UUID idCliente);
}
