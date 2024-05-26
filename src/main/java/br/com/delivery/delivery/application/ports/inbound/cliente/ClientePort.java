package br.com.delivery.delivery.application.ports.inbound.cliente;

import br.com.delivery.delivery.adapters.outbound.repository.cliente.ClienteEntity;

public interface ClientePort {

    void salvar(ClienteEntity clientEntity);
    
    ClienteEntity findByCpf(String cpf);
}
