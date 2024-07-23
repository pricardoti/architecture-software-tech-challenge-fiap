package br.com.fiap.delivery.infrastructure.gateways.clientes;

import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.domain.cliente.Cliente;
import br.com.fiap.delivery.infrastructure.gateways.clientes.mappers.ClienteEntityMapper;
import br.com.fiap.delivery.infrastructure.persistence.clientes.ClienteRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClienteGatewayJPA implements ClienteGateway {

    private final ClienteRepositoryJPA clienteRepository;

    @Override
    @Transactional
    public Cliente cadastrar(Cliente cliente) {
        var clienteEntity = ClienteEntityMapper.toEntity(cliente);
        clienteRepository.save(clienteEntity);
        return ClienteEntityMapper.toDomain(clienteEntity);
    }

    @Override
    public Cliente consultarPorCpf(String cpf) {
        var buscarPorCpf = clienteRepository.findByCpf(cpf);
        return buscarPorCpf.map(ClienteEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Collection<Cliente> consultarClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteEntityMapper::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public Cliente atualizar(Cliente cliente) {
        var clienteEntity = ClienteEntityMapper.toEntity(cliente);
        clienteRepository.save(clienteEntity);
        return ClienteEntityMapper.toDomain(clienteEntity);
    }

    @Override
    @Transactional
    public void excluir(UUID codigoCliente) {
        // TODO: mudar para uma exclusão logica na base de dados
        clienteRepository.deleteById(codigoCliente);
    }
}
