package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.domain.cliente.Credencial;
import br.com.delivery.delivery.application.domain.cliente.Endereco;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Accessors(fluent = true)
@Table(name = "clientes")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private String cpf;

    // TODO: mapear value objects
    // private Credencial credencial;
    // private Endereco endereco;

    public static ClienteEntity from(Cliente cliente) {
        var clienteEntity = new ClienteEntity();
        clienteEntity.nome(cliente.nome());
        clienteEntity.sobrenome(cliente.sobrenome());
        clienteEntity.cpf(cliente.cpf());

        // TODO: mapear value objects
        // clienteEntity.cpf(cliente.endereco());
        // clienteEntity.cpf(cliente.credencial());

        return clienteEntity;
    }
}
