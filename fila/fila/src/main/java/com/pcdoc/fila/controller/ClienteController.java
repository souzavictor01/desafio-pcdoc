//Classe que define a interface REST
package com.pcdoc.fila.controller; 

import com.pcdoc.fila.model.Cliente;
import com.pcdoc.fila.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fila") //Define o caminho base para todos os métodos dessa classe.
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired  //injeçao de dependencia
    private ClienteService service;

     // Endpoint para adicionar um cliente à fila (POST /fila)

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return service.adicionar(cliente);
    }

    // Endpoint para listar todos os clientes da fila (GET /fila)

    @GetMapping
    public List<Cliente> listar() {
        return service.listarFila();
    }

     // Endpoint para atender (remover) um cliente da fila pelo ID (DELETE /fila/{id})

    @DeleteMapping("/{id}")
    public void atender(@PathVariable Long id) {
        service.atender(id);
    }
}
