package com.pcdoc.fila.model;

public enum TipoAtendimento {
    GESTANTE(1), // prioriade máxima
    IDOSO(1),
    PCD(1),
    ENCAMINHADO(2),  //prioriade média
    GERAL(3); //prioriade baixa

    private final int prioridade;

    TipoAtendimento(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }
}
