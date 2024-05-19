package br.com.delivery.delivery.application.ports.inbound.avaliacao;

import java.util.UUID;

public interface ExcluirAvaliacaoPort {

    void excluir(UUID idAvaliacao);
}
