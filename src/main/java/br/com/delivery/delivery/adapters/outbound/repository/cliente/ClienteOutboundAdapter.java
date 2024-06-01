package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.ports.outbound.cliente.CadastrarClienteOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.ConsultarClienteOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.EditarClienteOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.ExcluirClienteOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository
                .save(ClienteEntity.from(cliente))
                .toDomain();
    }

    @Override
    public Cliente consultarPorCpf(String cpf) {
        var buscarPorCpf = clienteRepository.findByCpf(cpf);
        return buscarPorCpf.map(ClienteEntity::toDomain).orElse(null);
    }

    @Override
    public Collection<Cliente> consultarClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteEntity::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public Cliente editar(Cliente cliente) {
        var clientEntity = clienteRepository.save(ClienteEntity.from(cliente));
        return clientEntity.toDomain();
    }

    @Override
    @Transactional
    public void excluir(UUID codigoCliente) {
        clienteRepository.deleteById(codigoCliente);
    }
}
