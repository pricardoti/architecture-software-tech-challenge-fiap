package br.com.delivery.delivery.adapters.inbound.cliente.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponse {

	private Long id;
	private String cpf;
    private String nome;
    private String sobrenome;
    private EnderecoDTO endereco;
}
