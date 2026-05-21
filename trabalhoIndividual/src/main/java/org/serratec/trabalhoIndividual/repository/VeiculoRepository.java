package org.serratec.trabalhoIndividual.repository;

import org.serratec.trabalhoIndividual.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {
    List<Veiculo> findAll();

    Veiculo save(Veiculo veiculo);

    void deleteById(UUID id);

    Optional<Veiculo> findByPlaca(String placa);

    boolean existsById(UUID id);

    Optional<Veiculo> findByModelo(String modelo);

    Optional<Veiculo> findByMarca(String marca);
}
