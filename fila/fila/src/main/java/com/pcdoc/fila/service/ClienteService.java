package com.pcdoc.fila.service;

import com.pcdoc.fila.model.Cliente;
import com.pcdoc.fila.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente adicionar(Cliente cliente) {
        cliente.setPrioridade(cliente.getTipo().getPrioridade());
        return repository.save(cliente);
    }

    public List<Cliente> listarFila() {
        List<Cliente> fila = repository.findAll();
        fila.sort(Comparator.comparingInt(Cliente::getPrioridade));
        return fila;
    }

    public void atender(Long id) {
        repository.deleteById(id);
    }
}
