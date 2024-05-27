package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import br.com.delivery.delivery.application.domain.cliente.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Entity
@Accessors(fluent = true)
@Table(name = "enderecos")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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

    @OneToOne
    @JoinColumn(referencedColumnName = "codigo", name = "codigo_cliente")
    private ClienteEntity cliente;

    public static EnderecoEntity from(Endereco endereco) {
        return new EnderecoEntity(
                endereco.codigo(),
                endereco.logradouro(),
                endereco.numero(),
                endereco.complemento(),
                endereco.bairro(),
                endereco.cidade(),
                endereco.cep(),
                null
        );
    }

    public Endereco convertToEndereco() {
        return new Endereco(
                codigo,
                logradouro,
                numero,
                complemento,
                bairro,
                cidade,
                cep
        );
    }

    public EnderecoEntity(UUID codigo,
                          String logradouro,
                          String numero,
                          String complemento,
                          String bairro,
                          String cidade,
                          String cep
    ) {
        this.codigo = codigo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }
}
