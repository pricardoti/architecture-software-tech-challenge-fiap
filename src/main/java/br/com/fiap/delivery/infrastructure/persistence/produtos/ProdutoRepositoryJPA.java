package br.com.fiap.delivery.infrastructure.persistence.produtos;

import br.com.fiap.delivery.domain.produto.CategoriaProduto;
import br.com.fiap.delivery.infrastructure.persistence.produtos.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProdutoRepositoryJPA extends JpaRepository<ProdutoEntity, UUID> {

    Collection<ProdutoEntity> findByCategoria(CategoriaProduto categoriaProduto);

    Optional<ProdutoEntity> findByNomeAndCategoria(String nome, CategoriaProduto categoriaProduto);
}
