package org.serratec.trabalhoIndividual.model;

import lombok.Data;
import org.serratec.trabalhoIndividual.entity.Veiculo;

import java.util.UUID;

@Data
public class VeiculoBuscar {

    private UUID id;
    private UUID clienteId;
    private String marca;
    private String modelo;
    private int ano;
    private double valor;
    private String placa;
    private String maximoDesconto;
    private boolean vendido;
    private Double valorVenda;

    public VeiculoBuscar (Veiculo veiculo){
        this.id = veiculo.getId();
        this.clienteId = veiculo.getCliente().getId();
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
        this.valor = veiculo.getValor();
        this.placa = veiculo.getPlaca();
        this.maximoDesconto = veiculo.getMaximoDesconto();
        this.vendido = veiculo.isVendido();
        this.valorVenda = veiculo.getValorVenda();
    }

}
