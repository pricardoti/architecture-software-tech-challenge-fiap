package br.com.fiap.delivery.infrastructure.gateways.clientes.mappers;

import br.com.fiap.delivery.domain.cliente.Cliente;
import br.com.fiap.delivery.infrastructure.persistence.clientes.entities.ClienteEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClienteEntityMapper {

    public static ClienteEntity toEntity(Cliente cliente) {
        var enderecoEntity = EnderecoEntityMapper.toEntity(cliente.getEndereco());
        var clienteEntity = new ClienteEntity(
                cliente.getCodigo(),
                cliente.getCpf(),
                cliente.getNomeCompleto(),
                cliente.getEmail(),
                enderecoEntity
        );
        return clienteEntity;
    }

    public static Cliente toDomain(ClienteEntity entity) {
        return new Cliente(
                entity.codigo(),
                entity.cpf(),
                entity.nomeCompleto(),
                entity.email(),
                EnderecoEntityMapper.toDomain(entity.endereco())
        );
    }
}
