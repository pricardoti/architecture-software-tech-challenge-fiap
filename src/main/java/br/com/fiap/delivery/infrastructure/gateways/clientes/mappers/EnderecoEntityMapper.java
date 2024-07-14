package br.com.fiap.delivery.infrastructure.gateways.clientes.mappers;

import br.com.fiap.delivery.domain.cliente.Endereco;
import br.com.fiap.delivery.infrastructure.persistence.clientes.entities.EnderecoEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EnderecoEntityMapper {

    public static EnderecoEntity toEntity(Endereco endereco) {
        return new EnderecoEntity(
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

    public static Endereco toDomain(EnderecoEntity entity) {
        return new Endereco(
                entity.codigo(),
                entity.logradouro(),
                entity.numero(),
                entity.complemento(),
                entity.bairro(),
                entity.cidade(),
                entity.cep(),
                entity.uf()
        );
    }
}
