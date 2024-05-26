package br.com.delivery.delivery.application.ports.outbound.cliente;

import br.com.delivery.delivery.adapters.outbound.repository.cliente.ClienteEntity;

public interface ClientePortOut {

	void salvar(ClienteEntity clienteEntity);
	
	ClienteEntity findByCpf(String cpf);
    
}
