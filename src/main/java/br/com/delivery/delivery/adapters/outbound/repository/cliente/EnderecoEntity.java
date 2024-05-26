package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Entity
@Accessors(fluent = true)
@Table(name = "endereco")
public class EnderecoEntity {

	@Id
	private Long id;
	private String rua;
	private String bairro;
	private String cidade;
	private String numero;
	private String cep;
}
