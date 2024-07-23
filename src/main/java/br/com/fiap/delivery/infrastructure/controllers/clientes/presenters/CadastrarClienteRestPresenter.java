package br.com.fiap.delivery.infrastructure.controllers.clientes.presenters;

import br.com.fiap.delivery.application.presenters.CadastrarClientePresenter;
import br.com.fiap.delivery.domain.cliente.Cliente;
import br.com.fiap.delivery.infrastructure.controllers.clientes.dtos.CadastrarClienteResponse;
import org.springframework.stereotype.Component;

@Component
public class CadastrarClienteRestPresenter implements CadastrarClientePresenter<CadastrarClienteResponse> {

    @Override
    public CadastrarClienteResponse handler(Cliente cliente) {
        return new CadastrarClienteResponse(cliente.getCodigo().toString());
    }
}
