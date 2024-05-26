package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(fluent = true)
@Table(name = "clientes")
public class ClienteEntity {

	@Id
	private Long id;
	private String cpf;
    private String nome;
    private String sobrenome;
    private EnderecoEntity endereco;
      
}
