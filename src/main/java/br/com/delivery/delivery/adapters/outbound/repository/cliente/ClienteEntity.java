package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Accessors(fluent = true)
@Table(name = "clientes")
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 2526137963441029927L;

    @EqualsAndHashCode.Include
    @Id
    private UUID codigo;

    @Column(unique = true)
    private String cpf;
    private String nomeCompleto;
    private String email;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private EnderecoEntity endereco;

    public static ClienteEntity from(Cliente cliente) {
        var enderecoEntity = EnderecoEntity.from(cliente.getEndereco());
        var clienteEntity = new ClienteEntity(
                cliente.getCodigo(),
                cliente.getCpf(),
                cliente.getNomeCompleto(),
                cliente.getEmail(),
                enderecoEntity
        );
        enderecoEntity.cliente(clienteEntity);
        return clienteEntity;
    }

    public Cliente toDomain() {
        return new Cliente(
                codigo,
                cpf,
                nomeCompleto,
                email,
                endereco.convertToEndereco()
        );
    }

}
