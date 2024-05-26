package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import org.springframework.stereotype.Component;

import br.com.delivery.delivery.application.ports.outbound.cliente.CadastrarClienteOutboundPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarClienteOutboundAdapter implements CadastrarClienteOutboundPort {

    private final ClienteRepository clienteRepository;

	@Override
	public ClienteEntity findByCpf(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}

	@Override
	public void salvar(ClienteEntity clientEntity) {
		clienteRepository.save(clientEntity);	
	}
}
