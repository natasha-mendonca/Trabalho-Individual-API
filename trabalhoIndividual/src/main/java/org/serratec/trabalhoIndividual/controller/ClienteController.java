package org.serratec.trabalhoIndividual.controller;

import jakarta.validation.Valid;
import org.serratec.trabalhoIndividual.entity.Cliente;
import org.serratec.trabalhoIndividual.model.ClienteBuscar;
import org.serratec.trabalhoIndividual.model.ClienteCriar;
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
    public ResponseEntity<?> buscarCliente(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf) {

        if (nome != null && !nome.isBlank()) {
            List<ClienteBuscar> clientes = new ArrayList<>();
            Cliente cliente1 = clienteService.buscarPorNome(nome);
            clientes.add(new ClienteBuscar(cliente1));

            return ResponseEntity.ok(clientes);
        }
        if (cpf != null && !cpf.isBlank()) {
            Cliente cliente = clienteService.buscarPorCpf(cpf);
            return ResponseEntity.ok(new ClienteBuscar(cliente));
        }
        if (cpf == null && nome == null) {
            List<ClienteBuscar> clientes = clienteService.listarClientes();
            return ResponseEntity.ok(clientes);
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Informe nome ou cpf para fazer a pesquisa");
    }

    @PostMapping
    public ResponseEntity<ClienteBuscar> inserirCliente(@RequestBody @Valid ClienteCriar cliente){

        ClienteBuscar clientenovo = this.clienteService.inserirCliente(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientenovo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable UUID id){

        clienteService.deletarCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

