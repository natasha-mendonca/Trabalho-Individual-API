package org.serratec.trabalhoIndividual.controller;

import jakarta.validation.Valid;
import org.serratec.trabalhoIndividual.entity.Cliente;
import org.serratec.trabalhoIndividual.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping("/clientes")
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
            List<Cliente> cliente = clienteService.buscarPorNome ();

            return ResponseEntity.ok(cliente);
        }
        if (cpf != null && !cpf.isBlank()) {
            Cliente cliente = clienteService.buscaPorCpf ();
            return ResponseEntity.ok(cliente);
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

