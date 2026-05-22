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

    public Cliente buscarPorCpf (String cpf) {
        Optional<Cliente> clienteOpt = this.clienteRepository.findByCpf(cpf);

        if (clienteOpt.isEmpty()) {
            throw new ClienteNaoEncontrado("Cliente não Encontrado");
        }

        return clienteOpt.get();
    }

    public Cliente buscarPorNome(String nome) {
        Optional<Cliente> clienteOpt = this.clienteRepository.findByCpf(nome);

        if (clienteOpt.isEmpty()) {
            throw new ClienteNaoEncontrado("Cliente não Encontrado");
        }

        return clienteOpt.get();
    }

    public Cliente inserirCliente(Cliente cliente) {
        if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()){
            throw new CpfJaCadastrado("CPF ja Cadastrado");
        }
        return clienteRepository.save(cliente);
    }

    public void deletarCliente(UUID id) {
        if (!clienteRepository.existsById(id)){
            throw new ClienteNaoEncontrado("Cliente não Encontrado.");
        }

        clienteRepository.deleteById(id);
    }


}
