package br.com.delivery.delivery.application.usecases.cliente;


import br.com.delivery.delivery.adapters.inbound.cliente.dto.CadastrarClienteRequest;
import br.com.delivery.delivery.adapters.outbound.repository.cliente.ClienteEntity;
import br.com.delivery.delivery.application.ports.inbound.cliente.CadastrarClienteInboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.CadastrarClienteOutboundPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class CadastrarClienteInboundUseCase implements CadastrarClienteInboundPort {

    private final CadastrarClienteOutboundPort cadastrarClienteOutboundPort;

    @Override
    public void salvar(CadastrarClienteRequest cadastrarClienteRequest) {
        ModelMapper modelMapper = new ModelMapper();
        ClienteEntity cliente = modelMapper.map(cadastrarClienteRequest, ClienteEntity.class);
        cadastrarClienteOutboundPort.salvar(cliente);
    }
}
