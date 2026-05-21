package org.serratec.trabalhoIndividual.entity;

import jakarta.persistence.*;
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
@NotNull
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Size(max = 60)
    @Column
    private String nome;

    @Column(unique = true, length = 11)
    private String cpf;

    @Size(max=50)
    @Column(unique = true, length = 50)
    private String email;

    @Column(length = 13)
    private String telefone;

}
