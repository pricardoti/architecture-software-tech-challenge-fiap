package br.com.delivery.delivery.adapters.inbound.cliente.dto;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class ClienteResponse {

	@CPF
	@NotNull
	private String cpf;
    @NotNull
    private String nome;
    @NotNull
    private String sobrenome;
    private EnderecoDTO endereco;
}
