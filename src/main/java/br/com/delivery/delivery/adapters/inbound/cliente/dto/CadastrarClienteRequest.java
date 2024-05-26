package br.com.delivery.delivery.adapters.inbound.cliente.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class CadastrarClienteRequest {

	@CPF
	@NotNull
	private String cpf;
    @NotNull
    private String nome;
    @NotNull
    private String sobrenome;
    private EnderecoDTO endereco;
}
