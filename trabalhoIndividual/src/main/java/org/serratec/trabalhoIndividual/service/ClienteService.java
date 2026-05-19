package org.serratec.trabalhoIndividual.service;

import org.serratec.trabalhoIndividual.entity.Cliente;
import org.serratec.trabalhoIndividual.exception.ClienteNaoEncontrado;
import org.serratec.trabalhoIndividual.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

        @Autowired
        private ClienteRepository clienteRepository;

        public List<Cliente> listaClientes() {
            return clienteRepository.findAll();
        }

        public Cliente buscarCliente(Long id) {
            Optional<Cliente> clienteOpt = this.clienteRepository.findById(id);

            if (clienteOpt.isEmpty()) {
                throw new ClienteNaoEncontrado("Cliente não encontrado");
            }

            return clienteOpt.get();
        }

        public Cliente inserirCliente(Cliente cliente) {

            return clienteRepository.save(cliente);
        }

        public void deleteCliente(Long id) {
            clienteRepository.deleteById(id);
        }

        public Cliente atualizaCliente(Long id, String email) {
            Cliente cliente = clienteRepository.findById(id).get();
            cliente.setEmail(email);

            return clienteRepository.save(cliente);
        }
    }
