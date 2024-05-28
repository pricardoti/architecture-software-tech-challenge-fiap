package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.repository.cdi.Eager;

import java.io.Serial;
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
@Eager
public class ClienteEntity implements Serializable {

    @Serial
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
        var enderecoEntity = EnderecoEntity.from(cliente.endereco());
        var clienteEntity = new ClienteEntity(
                cliente.codigo(),
                cliente.cpf(),
                cliente.nomeCompleto(),
                cliente.email(),
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
