package br.com.delivery.delivery.application.ports.inbound.cliente;

import br.com.delivery.delivery.adapters.inbound.cliente.dto.CadastrarClienteRequest;

public interface ClientePortIn {

    void salvar(CadastrarClienteRequest cadastrarClienteRequest);
   
}
