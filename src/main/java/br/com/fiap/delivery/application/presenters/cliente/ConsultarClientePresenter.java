package br.com.fiap.delivery.application.presenters.cliente;

import br.com.fiap.delivery.domain.cliente.Cliente;

import java.util.Collection;

public interface ConsultarClientePresenter<T> {

    Collection<T> handler(Collection<Cliente> clientes);

    T handler(Cliente cliente);
}
