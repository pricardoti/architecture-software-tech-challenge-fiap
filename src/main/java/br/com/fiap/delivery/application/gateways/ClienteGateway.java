package br.com.fiap.delivery.application.gateways;

import br.com.fiap.delivery.domain.cliente.Cliente;

import java.util.Collection;
import java.util.UUID;

public interface ClienteGateway {

    Cliente cadastrar(Cliente cliente);

    Cliente atualizar(Cliente cliente);

    void excluir(UUID codigoCliente);

    Cliente consultarPorCpf(String cpf);

    Collection<Cliente> consultarClientes();
}
