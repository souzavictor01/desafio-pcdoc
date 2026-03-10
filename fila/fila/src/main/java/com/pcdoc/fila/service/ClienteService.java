package com.pcdoc.fila.service;

import com.pcdoc.fila.model.Cliente;
import com.pcdoc.fila.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository repository;

    // @Autowired
    // private ClienteRepository repository;

    // Adiciona um cliente na fila, calculando a prioridade com base no tipo
    public Cliente adicionar(Cliente cliente) {
        cliente.setPrioridade(cliente.getTipo().getPrioridade());
        return repository.save(cliente);
    }

    // Retorna a lista de clientes ordenada por prioridade
    public List<Cliente> listarFila() {
        List<Cliente> fila = repository.findAll();
        fila.sort(Comparator.comparingInt(Cliente::getPrioridade));
        return fila;
    }

    // Remove um cliente da fila pelo ID (atendimento concluído)
    public void atender(Long id) {
        repository.deleteById(id);
    }
}
