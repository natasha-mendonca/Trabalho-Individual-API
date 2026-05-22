package org.serratec.trabalhoIndividual.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class VeiculoCriar {

    @NotNull
    private UUID clienteId;

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
    private String placa;

    @NotNull
    private String maximoDesconto;

    @NotNull
    private boolean vendido;

    @Min(0)
    private Double valorVenda;

}
