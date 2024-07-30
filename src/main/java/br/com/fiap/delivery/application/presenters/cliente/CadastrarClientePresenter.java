package br.com.fiap.delivery.application.presenters.cliente;

import br.com.fiap.delivery.domain.cliente.Cliente;

public interface CadastrarClientePresenter<T> {

    T handler(Cliente cliente);
}
