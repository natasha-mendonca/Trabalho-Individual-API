package org.serratec.trabalhoIndividual.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @NotNull
    @Size(max = 60)
    @Column
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

    @NotNull
    @Min(0)
    @Column
    private double valor;

    @NotNull
    @Column(unique = true)
    private String placa;

    @NotNull
    @Column
    private String maximoDesconto;

    @NotNull
    @Column
    private boolean vendido;

    @Min(0)
    @Column
    private Double valorVenda;

}
