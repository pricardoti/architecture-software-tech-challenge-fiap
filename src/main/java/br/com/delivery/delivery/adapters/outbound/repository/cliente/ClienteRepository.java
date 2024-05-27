package br.com.delivery.delivery.adapters.outbound.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {
	
	ClienteEntity findByCpf(String cpf);
}
