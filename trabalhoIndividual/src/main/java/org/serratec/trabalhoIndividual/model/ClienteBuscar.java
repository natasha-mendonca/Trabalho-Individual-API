package org.serratec.trabalhoIndividual.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoIndividual.entity.Cliente;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteBuscar {

        private UUID id;
        private String nome;
        private String cpf;
        private String email;
        private String telefone;

        public ClienteBuscar (Cliente cliente){
                this.id = cliente.getId();
                this.nome = cliente.getNome();
                this.cpf = cliente.getCpf();
                this.email = cliente.getEmail();
                this.telefone = cliente.getTelefone();
        }

    }

