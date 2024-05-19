package br.com.delivery.delivery.application.ports.inbound.avaliacao;

import br.com.delivery.delivery.application.domain.avaliacao.Avaliacao;

public interface CadastrarAvaliacaoPort {

    Avaliacao salvar(Avaliacao avaliacao);
}
