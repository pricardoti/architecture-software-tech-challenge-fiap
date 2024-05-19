package br.com.delivery.delivery.application.ports.outbound.avaliacao;

import br.com.delivery.delivery.application.domain.avaliacao.Avaliacao;

public interface SalvarAvaliacaoPort {

    Avaliacao salvar(Avaliacao avaliacao);
}
