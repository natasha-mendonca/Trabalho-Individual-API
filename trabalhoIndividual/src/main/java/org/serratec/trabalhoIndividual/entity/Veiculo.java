package org.serratec.trabalhoIndividual.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoIndividual.model.VeiculoCriar;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Veiculo {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn
    private Cliente cliente;

    @NotNull
    @Column
    private String marca;

    @NotNull
    @Column
    private String modelo;

    @NotNull
    @Column(length = 4)
    private int ano;

    @Min(0)
    @Column
    private double valor;

    @NotNull
    @Column(unique = true)
    private String placa;

    @NotNull
    @Column
    private String maximoDesconto;

    @Column
    private boolean vendido;

    @Min(0)
    @Column
    private Double valorVenda;

    public Veiculo (VeiculoCriar veiculo, Cliente cliente){
        this.cliente = cliente;
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.placa = veiculo.getPlaca();
        this.ano = veiculo.getAno();
        this.maximoDesconto = veiculo.getMaximoDesconto();
        this.valor = veiculo.getValor();
        this.vendido = veiculo.isVendido();
        this.valorVenda = veiculo.getValorVenda();
    }
}
