package br.com.delivery.delivery.application.usecases.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.domain.cliente.Credencial;
import br.com.delivery.delivery.application.domain.cliente.Endereco;
import br.com.delivery.delivery.application.ports.inbound.cliente.CadastrarClientePort;
import br.com.delivery.delivery.application.ports.outbound.cliente.SalvarClientePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastrarClienteUseCase implements CadastrarClientePort {

    private final SalvarClientePort salvarClientePort;

    @Override
    public Cliente salvar(Cliente cliente) {
        return salvarClientePort.salvar(
                new Cliente(
                        "Nome Cliente",
                        "Sobrenome Cliente",
                        "00000000",
                        new Credencial("email@teste.com.br", "123"),
                        new Endereco("Logradouro", "123A", "Complemento", "2342342342", "Cidade", "Bairro")
                )
        );
    }
}
