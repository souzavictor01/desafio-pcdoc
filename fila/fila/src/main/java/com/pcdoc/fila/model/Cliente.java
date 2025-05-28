package com.pcdoc.fila.model;

import jakarta.persistence.*;
import lombok.Data; //gera automaticamente os getters, setters, equals, hashCode e toString

@Entity // indica que essa classe será uma entidade mapeada no banco de dados
@Data
public class Cliente {

    @Id //cahve primaria da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoAtendimento tipo;

    private Integer prioridade;
}
