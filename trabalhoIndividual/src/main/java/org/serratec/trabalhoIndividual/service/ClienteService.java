package org.serratec.trabalhoIndividual.service;

import org.serratec.trabalhoIndividual.entity.Cliente;
import org.serratec.trabalhoIndividual.exception.ClienteNaoEncontrado;
import org.serratec.trabalhoIndividual.exception.CpfJaCadastrado;
import org.serratec.trabalhoIndividual.model.ClienteBuscar;
import org.serratec.trabalhoIndividual.model.ClienteCriar;
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

    public List<ClienteBuscar> listarClientes() {
        List<Cliente> clientes = this.clienteRepository.findAll();

        return clientes
                .stream()
                .map(cliente -> new ClienteBuscar(cliente))
                .toList();
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

    public ClienteBuscar inserirCliente(ClienteCriar cliente) {
        if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()){
            throw new CpfJaCadastrado("CPF ja Cadastrado");
        }
        Cliente cliente1 = new Cliente(cliente);
        return new ClienteBuscar(clienteRepository.save(cliente1));
    }

    public void deletarCliente(UUID id) {
        if (!clienteRepository.existsById(id)){
            throw new ClienteNaoEncontrado("Cliente não Encontrado.");
        }

        clienteRepository.deleteById(id);
    }


}
