package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.ports.outbound.cliente.CadastrarClienteOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.ConsultarClienteOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.EditarClienteOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.ExcluirClienteOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClienteOutboundAdapter implements CadastrarClienteOutboundPort,
        ConsultarClienteOutboundPort,
        EditarClienteOutboundPort,
        ExcluirClienteOutboundPort {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository
                .save(ClienteEntity.from(cliente))
                .toDomain();
    }

    @Override
    public Cliente consultarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf).toDomain();
    }

    @Override
    public Collection<Cliente> consultarClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteEntity::toDomain)
                .toList();
    }

    @Override
    public Cliente editar(Cliente cliente) {
        var clientEntity = clienteRepository.save(ClienteEntity.from(cliente));
        return clientEntity.toDomain();
    }

    @Override
    public void excluir(UUID codigoCliente) {
        clienteRepository.deleteById(codigoCliente);
    }
}
