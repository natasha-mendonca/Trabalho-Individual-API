package org.serratec.trabalhoIndividual.service;

import org.serratec.trabalhoIndividual.entity.Cliente;
import org.serratec.trabalhoIndividual.exception.ClienteNaoEncontrado;
import org.serratec.trabalhoIndividual.exception.CpfJaCadastrado;
import org.serratec.trabalhoIndividual.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarCliente(String cpf) {
        Optional<Cliente> clienteOpt = this.clienteRepository.findByCpf(cpf);

        if (clienteOpt.isEmpty()) {
            throw new ClienteNaoEncontrado("Cliente não encontrado");
        }

        return clienteOpt.get();
    }

    public Cliente inserirCliente(Cliente cliente) {
        if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()){
            throw new CpfJaCadastrado("CPF ja cadastrado");
        }
        return clienteRepository.save(cliente);
    }

    public void deletarCliente(UUID id) {
        clienteRepository.deleteById(id);
    }

    public Cliente atualizaCliente(UUID id, String email) {
        Cliente cliente = clienteRepository.findById(id).get();
        cliente.setEmail(email);

        return clienteRepository.save(cliente);
    }
}
