package br.com.fiap.delivery.infrastructure.api.clientes.dtos;

import br.com.fiap.delivery.domain.cliente.Endereco;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter(onMethod = @__(@JsonProperty))
@Setter(onMethod = @__(@JsonProperty))
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEnderecoResponse {

    private UUID codigo;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;

    public ClienteEnderecoResponse(Endereco endereco) {
        this(
                endereco.getCodigo(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getCep(),
                endereco.getUf()
        );
    }
}
