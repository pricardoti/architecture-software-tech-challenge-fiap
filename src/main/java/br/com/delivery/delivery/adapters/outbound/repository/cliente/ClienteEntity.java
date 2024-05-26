package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Accessors(fluent = true)
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID codigo;
    @Column(unique = true)
    private String cpf;
    private String nome;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoEntity endereco;

}
