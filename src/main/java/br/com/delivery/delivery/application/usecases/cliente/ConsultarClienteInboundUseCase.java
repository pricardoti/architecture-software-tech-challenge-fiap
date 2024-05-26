package br.com.delivery.delivery.application.usecases.cliente;

import org.modelmapper.ModelMapper;

import br.com.delivery.delivery.adapters.inbound.cliente.dto.ClienteResponse;
import br.com.delivery.delivery.adapters.outbound.repository.cliente.ClienteEntity;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClienteInboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.CadastrarClienteOutboundPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsultarClienteInboundUseCase implements ConsultarClienteInboundPort {
	
	private final CadastrarClienteOutboundPort cadastrarClienteOutboundPort;
	
    @Override
    public ClienteResponse consultar(String cpf) {
    	ModelMapper modelMapper = new ModelMapper();
    	ClienteEntity clienteEntity = cadastrarClienteOutboundPort.findByCpf(cpf);
    	return modelMapper.map(clienteEntity, ClienteResponse.class);
    }
}
