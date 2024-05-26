package br.com.delivery.delivery.adapters.inbound.cliente.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

	private Long id;
	private String rua;
	private String bairro;
	private String cidade;
	private String numero;
	private String cep;
}
