package br.com.delivery.delivery.application.usecases.cliente;




import org.modelmapper.ModelMapper;

import br.com.delivery.delivery.adapters.inbound.cliente.dto.CadastrarClienteRequest;
import br.com.delivery.delivery.adapters.outbound.repository.cliente.ClienteEntity;
import br.com.delivery.delivery.application.ports.inbound.cliente.ClientePortIn;
import br.com.delivery.delivery.application.ports.outbound.cliente.ClientePortOut;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClienteUseCase implements ClientePortIn {

    private final ClientePortOut clientePortOut;

    @Override
    public void salvar(CadastrarClienteRequest cadastrarClienteRequest) {
    	ModelMapper modelMapper = new ModelMapper();
    	ClienteEntity cliente = modelMapper.map(cadastrarClienteRequest, ClienteEntity.class);
    	clientePortOut.salvar(cliente);
    }
}
