package br.com.delivery.delivery.application.usecases.cliente;

import br.com.delivery.delivery.adapters.inbound.cliente.dto.ClienteResponse;
import br.com.delivery.delivery.application.ports.inbound.cliente.ClientePort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClientePort;

public class ConsultarClienteUseCase implements ConsultarClientePort {
	
	private ClientePort clientport;
	
    @Override
    public ClienteResponse consultar(String cpf) {
        return null;
    }
}
