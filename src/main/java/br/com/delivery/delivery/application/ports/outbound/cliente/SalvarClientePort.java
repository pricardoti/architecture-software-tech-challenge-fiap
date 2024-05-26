package br.com.delivery.delivery.application.ports.outbound.cliente;

import br.com.delivery.delivery.adapters.inbound.cliente.dto.CadastrarClienteRequest;

public interface SalvarClientePort {

	void salvar(CadastrarClienteRequest cadastrarClienteRequest);
    
}
