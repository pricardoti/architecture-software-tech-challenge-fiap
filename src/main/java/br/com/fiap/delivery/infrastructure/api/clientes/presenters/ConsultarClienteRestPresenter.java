package br.com.fiap.delivery.infrastructure.api.clientes.presenters;

import br.com.fiap.delivery.application.presenters.cliente.ConsultarClientePresenter;
import br.com.fiap.delivery.domain.cliente.Cliente;
import br.com.fiap.delivery.infrastructure.api.clientes.dtos.ConsultarClienteResponse;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ConsultarClienteRestPresenter implements ConsultarClientePresenter<ConsultarClienteResponse> {

    @Override
    public Collection<ConsultarClienteResponse> handler(Collection<Cliente> clientes) {
        return clientes.stream()
                .map(ConsultarClienteResponse::new)
                .toList();
    }

    @Override
    public ConsultarClienteResponse handler(Cliente cliente) {
        return new ConsultarClienteResponse(cliente);
    }
}
