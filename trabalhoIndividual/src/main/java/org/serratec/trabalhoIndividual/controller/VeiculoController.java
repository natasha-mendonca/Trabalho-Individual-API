package org.serratec.trabalhoIndividual.controller;

import jakarta.validation.Valid;
import org.serratec.trabalhoIndividual.entity.Veiculo;
import org.serratec.trabalhoIndividual.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;


    @GetMapping
    public ResponseEntity<?> buscar (
            @RequestParam(required = false) String placa,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo){

        if (placa != null && !placa.isBlank()) {
            Veiculo veiculo = veiculoService.buscarPorPlaca(placa);
            return ResponseEntity.status(HttpStatus.OK).body(veiculo);
        }

        if (marca != null && !marca.isBlank()) {
            List<Veiculo> veiculos = new ArrayList<>();
            Veiculo veiculo1 = veiculoService.buscarPorMarca(marca);
            veiculos.add(veiculo1);

            return ResponseEntity.status(HttpStatus.OK).body(veiculos);
        }

        if (modelo != null && !modelo.isBlank()) {
            List<Veiculo> veiculos = new ArrayList<>();
            Veiculo veiculo1 = veiculoService.buscarPorModelo(modelo);
            veiculos.add(veiculo1);

            return ResponseEntity.status(HttpStatus.OK).body(veiculos);
        }

        if (placa == null && marca == null && modelo ==null){
            List<Veiculo> veiculo = veiculoService.listarVeiculo();

            return ResponseEntity.ok(veiculo);
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Informe 'placa', 'marca' ou 'modelo' para realizar a buscar.");
    }
    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody @Valid Veiculo veiculo){
        Veiculo veiculonovo = this.veiculoService.cadastrarVeiculo(veiculo);

        return ResponseEntity.status(HttpStatus.CREATED).body(veiculonovo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable UUID id){

        veiculoService.deletarVeiculo(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar (@PathVariable UUID id, @Valid @RequestBody Veiculo veiculo) {
        Veiculo veiculoAtualizado = veiculoService.atualizarVeiculo(id, veiculo);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoAtualizado);
    }

}
