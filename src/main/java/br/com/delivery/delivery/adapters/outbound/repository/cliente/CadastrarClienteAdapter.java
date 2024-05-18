package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.ports.outbound.cliente.SalvarClientePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarClienteAdapter implements SalvarClientePort {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(Cliente cliente) {
        clienteRepository.save(ClienteEntity.from(cliente));
        return cliente;
    }
}
