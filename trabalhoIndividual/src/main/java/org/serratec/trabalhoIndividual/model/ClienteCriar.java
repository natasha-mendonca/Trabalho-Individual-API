package org.serratec.trabalhoIndividual.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@NotNull
public class ClienteCriar {

        @Size(max = 60)
        private String nome;

        private String cpf;

        @Size(max=50)
        private String email;

        private String telefone;

    }

