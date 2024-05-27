package br.com.delivery.delivery.application.usecases.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClienteInboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.ConsultarClienteOutboundPort;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RequiredArgsConstructor
public class ConsultarClienteInboundUseCase implements ConsultarClienteInboundPort {

    private final ConsultarClienteOutboundPort consultarClienteOutboundPort;

    @Override
    public Cliente consultarPorCpf(String cpf) {
        return consultarClienteOutboundPort.consultarPorCpf(cpf);
    }

    @Override
    public Collection<Cliente> consultarClientes() {
        return consultarClienteOutboundPort.consultarClientes();
    }
}
