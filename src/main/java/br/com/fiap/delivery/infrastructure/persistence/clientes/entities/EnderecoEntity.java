package br.com.fiap.delivery.infrastructure.persistence.clientes.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Accessors(fluent = true)
@Table(name = "enderecos")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnderecoEntity implements Serializable {

    private static final long serialVersionUID = 1662069931406378792L;

    @Id
    @EqualsAndHashCode.Include
    private UUID codigo;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;

    @Column(length = 9)
    private String cep;

    @Column(length = 2)
    private String uf;

    @OneToOne
    @JoinColumn(referencedColumnName = "codigo", name = "codigo_cliente")
    private ClienteEntity cliente;

    public EnderecoEntity(
            UUID codigo,
            String logradouro,
            String numero,
            String complemento,
            String bairro,
            String cidade,
            String cep,
            String uf
    ) {
        this.codigo = codigo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
    }
}
