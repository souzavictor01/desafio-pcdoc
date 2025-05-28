package com.pcdoc.fila.controller;

import com.pcdoc.fila.model.Cliente;
import com.pcdoc.fila.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fila")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return service.adicionar(cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listarFila();
    }

    @DeleteMapping("/{id}")
    public void atender(@PathVariable Long id) {
        service.atender(id);
    }
}
