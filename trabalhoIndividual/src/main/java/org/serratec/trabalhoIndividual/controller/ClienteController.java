package org.serratec.trabalhoIndividual.controller;

import jakarta.validation.Valid;
import org.serratec.trabalhoIndividual.entity.Cliente;
import org.serratec.trabalhoIndividual.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RequestMapping("api/v1/cliente")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listaClientes(){

        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{buscar}")
    public ResponseEntity<?> buscarCliente(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf) {

        if (nome != null && !nome.isBlank()) {
            List<Cliente> clientes = new ArrayList<>();
            Cliente cliente1 = clienteService.buscarPorNome(nome);
            clientes.add(cliente1);

            return ResponseEntity.ok(clientes);
        }
        if (cpf != null && !cpf.isBlank()) {
            Cliente cliente = clienteService.buscarPorCpf(cpf);
            return ResponseEntity.ok(cliente);
        }
        if (cpf == null && nome == null) {

            return ResponseEntity.ok(clienteService.listarClientes());
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Informe nome ou cpf para fazer a pesquisa");
    }

    @PostMapping
    public ResponseEntity<Cliente> inserirCliente(@RequestBody @Valid Cliente cliente){
        Cliente clientenovo = this.clienteService.inserirCliente(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientenovo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable UUID id){

        clienteService.deletarCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

