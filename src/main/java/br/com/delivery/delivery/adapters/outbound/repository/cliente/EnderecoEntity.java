package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {

    @Id
    @EqualsAndHashCode.Include
    private UUID codigo;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
}
