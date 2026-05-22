package org.serratec.trabalhoIndividual.controller;

import jakarta.validation.Valid;
import org.serratec.trabalhoIndividual.entity.Veiculo;
import org.serratec.trabalhoIndividual.model.VeiculoAtualizar;
import org.serratec.trabalhoIndividual.model.VeiculoBuscar;
import org.serratec.trabalhoIndividual.model.VeiculoCriar;
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
    public ResponseEntity<List<VeiculoBuscar>> buscar (
            @RequestParam(required = false) String placa,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo){
        List<VeiculoBuscar> veiculos = new ArrayList<>();

        if (placa != null && !placa.isBlank()) {
            Veiculo veiculo = veiculoService.buscarPorPlaca(placa);
            veiculos.add(new VeiculoBuscar(veiculo));
            return ResponseEntity.status(HttpStatus.OK).body(veiculos);

        }

        if (marca != null && !marca.isBlank()) {

            Veiculo veiculo1 = veiculoService.buscarPorMarca(marca);
            veiculos.add(new VeiculoBuscar(veiculo1));

            return ResponseEntity.status(HttpStatus.OK).body(veiculos);
        }

        if (modelo != null && !modelo.isBlank()) {
            Veiculo veiculo1 = veiculoService.buscarPorModelo(modelo);
            veiculos.add(new VeiculoBuscar(veiculo1));

            return ResponseEntity.status(HttpStatus.OK).body(veiculos);
        }

        if (placa == null && marca == null && modelo ==null){
            List<Veiculo> veiculo2 = veiculoService.listarVeiculo();

            return ResponseEntity.status(HttpStatus.OK).body(veiculo2
                    .stream()
                    .map(veiculo -> new VeiculoBuscar(veiculo))
                    .toList());
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(veiculos);
    }
    @PostMapping
    public ResponseEntity<VeiculoBuscar> cadastrarVeiculo(@RequestBody @Valid VeiculoCriar veiculo){
        VeiculoBuscar veiculonovo = this.veiculoService.cadastrarVeiculo(veiculo);

        return ResponseEntity.status(HttpStatus.CREATED).body(veiculonovo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable UUID id){

        veiculoService.deletarVeiculo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoAtualizar> atualizar (@PathVariable UUID id, @Valid @RequestBody VeiculoAtualizar veiculo) {
        VeiculoAtualizar veiculoAtualizado = veiculoService.atualizarVeiculo(id, veiculo);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoAtualizado);
    }

}
