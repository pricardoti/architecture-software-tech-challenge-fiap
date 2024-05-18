package br.com.delivery.delivery.adapters.inbound.cliente.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class CadastrarClienteRequest {

    @NotNull
    private String nome;

    @NotNull
    private String sobreNome;

    @CPF
    @NotNull
    private String cpf;
}
