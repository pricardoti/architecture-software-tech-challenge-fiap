package br.com.delivery.delivery.application.usecases.cliente;

import org.modelmapper.ModelMapper;

import br.com.delivery.delivery.adapters.inbound.cliente.dto.ClienteResponse;
import br.com.delivery.delivery.adapters.outbound.repository.cliente.ClienteEntity;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClientePort;
import br.com.delivery.delivery.application.ports.outbound.cliente.ClientePortOut;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsultarClienteUseCase implements ConsultarClientePort {
	
	private final ClientePortOut clientePortOut;
	
    @Override
    public ClienteResponse consultar(String cpf) {
    	ModelMapper modelMapper = new ModelMapper();
    	ClienteEntity clienteEntity = clientePortOut.findByCpf(cpf);
    	return modelMapper.map(clienteEntity, ClienteResponse.class);
    }
}
