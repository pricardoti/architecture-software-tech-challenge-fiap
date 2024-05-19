package br.com.delivery.delivery.application.ports.inbound.cliente;

import java.util.UUID;

public interface ExcluirClientePort {

    void excluir(UUID idCliente);
}
