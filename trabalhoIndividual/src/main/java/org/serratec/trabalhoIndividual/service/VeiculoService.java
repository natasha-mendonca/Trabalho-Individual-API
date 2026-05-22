package org.serratec.trabalhoIndividual.service;


import org.serratec.trabalhoIndividual.entity.Veiculo;
import org.serratec.trabalhoIndividual.exception.CampoObrigatorio;
import org.serratec.trabalhoIndividual.exception.PlacaJaCadastrada;
import org.serratec.trabalhoIndividual.exception.VeiculoNaoEncontrado;
import org.serratec.trabalhoIndividual.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarVeiculo() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscarPorPlaca(String placa) {
        Optional<Veiculo> veiculoOpt = this.veiculoRepository.findByPlaca(placa);

        if (veiculoOpt.isEmpty()) {
            throw new VeiculoNaoEncontrado("Veiculo não Encontrado");
        }
        return veiculoOpt.get();
    }

    public Veiculo buscarPorModelo(String modelo) {
        Optional<Veiculo> veiculoOpt = this.veiculoRepository.findByModelo(modelo);

        if (veiculoOpt.isEmpty()) {
            throw new VeiculoNaoEncontrado("Veiculo não Encontrado");
        }
        return veiculoOpt.get();
    }

    public Veiculo buscarPorMarca(String marca) {
        Optional<Veiculo> veiculoOpt = this.veiculoRepository.findByMarca(marca);

        if (veiculoOpt.isEmpty()) {
            throw new VeiculoNaoEncontrado("Veiculo não Encontrado");
        }
        return veiculoOpt.get();
    }
    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        if (veiculoRepository.findByPlaca(veiculo.getPlaca()).isPresent()) {
            throw new PlacaJaCadastrada("Placa ja Cadastrada");
        }
        return veiculoRepository.save(veiculo);
    }

    public void deletarVeiculo(UUID id) {

        if (!veiculoRepository.existsById(id)) {
            throw new VeiculoNaoEncontrado("Veiculo não Encontrado");
        }
        this.veiculoRepository.deleteById(id);
    }

    public Veiculo atualizarVeiculo (UUID id,Veiculo veiculo){
        Optional<Veiculo> veiculoOpt = veiculoRepository.findById(id);

        if (veiculo.isVendido() && veiculo.getValorVenda() == null) {
            throw new CampoObrigatorio("Valor de Venda não Informado");
        }

        if(veiculoOpt.isEmpty()){
            throw new VeiculoNaoEncontrado("Veiculo com id: " + id + ", não Encontrado");
        }
        Veiculo veiculoExistente =  veiculoOpt.get();

        veiculoExistente.setMarca(veiculo.getMarca());
        veiculoExistente.setModelo(veiculo.getModelo());
        veiculoExistente.setAno(veiculo.getAno());
        veiculoExistente.setValor(veiculo.getValor());
        veiculoExistente.setMaximoDesconto(veiculo.getMaximoDesconto());
        veiculoExistente.setVendido(veiculo.isVendido());
        veiculoExistente.setValorVenda(veiculo.getValorVenda());


        return veiculoRepository.save(veiculoExistente);
    }
}