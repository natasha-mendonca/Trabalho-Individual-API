package org.serratec.trabalhoIndividual.repository;


import org.serratec.trabalhoIndividual.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    Optional<Cliente> findById(Long id);

    void deleteById(Long id);

    List<Cliente> findAll();

    Cliente save(Cliente cliente);

    Optional<Cliente> findByCpf(String cpf);
}
