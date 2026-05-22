package org.serratec.trabalhoIndividual.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoIndividual.entity.Veiculo;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class VeiculoAtualizar {

    @NotNull
    private String marca;

    @NotNull
    private String modelo;

    @NotNull
    private int ano;

    @NotNull
    @Min(0)
    private double valor;

    @NotNull
    private String maximoDesconto;

    @NotNull
    private boolean vendido;

    @Min(0)
    private Double valorVenda;

    public VeiculoAtualizar (Veiculo veiculo){
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
        this.valor = veiculo.getValor();
        this.maximoDesconto = veiculo.getMaximoDesconto();
        this.vendido = veiculo.isVendido();
        this.valorVenda = veiculo.getValorVenda();
    }
}
