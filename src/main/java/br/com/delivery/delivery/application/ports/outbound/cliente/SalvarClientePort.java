package br.com.delivery.delivery.application.ports.outbound.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;

public interface SalvarClientePort {

    Cliente salvar(Cliente cliente);
}
