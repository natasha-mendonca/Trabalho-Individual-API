package org.serratec.trabalhoIndividual.repository;


import org.serratec.trabalhoIndividual.entity.Cliente;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository {

    Optional<Cliente> findById(Long id);

    void deleteById(Long id);

    List<Cliente> findAll();

    Cliente save(Cliente cliente);
}
