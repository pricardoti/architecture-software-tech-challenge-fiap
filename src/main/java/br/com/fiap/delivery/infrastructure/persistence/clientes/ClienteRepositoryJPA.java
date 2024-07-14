package br.com.fiap.delivery.infrastructure.persistence.clientes;

import br.com.fiap.delivery.infrastructure.persistence.clientes.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepositoryJPA extends JpaRepository<ClienteEntity, UUID> {

    Optional<ClienteEntity> findByCpf(String cpf);
}
