package org.serratec.trabalhoIndividual.controller;

import jakarta.validation.Valid;
import org.serratec.trabalhoIndividual.entity.Cliente;
import org.serratec.trabalhoIndividual.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/clientes")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listaClientes(){

        return ResponseEntity.ok(clienteService.listaClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id){
        Cliente cliente = this.clienteService.buscarCliente(id);

        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> inserirCliente(@RequestBody @Valid Cliente cliente){
        Cliente clientenovo = this.clienteService.inserirCliente(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientenovo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){

        clienteService.deleteCliente(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

