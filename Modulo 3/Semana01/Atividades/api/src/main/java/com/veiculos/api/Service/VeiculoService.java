package com.veiculos.api.Service;

import com.veiculos.api.Exceptions.RegistroExistenteException;
import com.veiculos.api.Exceptions.RegistroNaoEncontradoException;
import com.veiculos.api.Exceptions.VeiculoComMultasException;
import com.veiculos.api.Model.Veiculo;
import com.veiculos.api.Repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo inserir(Veiculo veiculo) {
        boolean existe = veiculoRepository.existsById(veiculo.getPlaca());
        if (existe) {
            throw new RegistroExistenteException();
        }
        veiculo = veiculoRepository.save(veiculo);
        return veiculo;
    }

    public List<Veiculo> consultar() {
        return veiculoRepository.findAll();
    }

    public Veiculo consultaId(String placa) {
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(placa);
        if(veiculoOptional.isEmpty()){
            throw new RegistroNaoEncontradoException();
        }
        return veiculoOptional.get();
    }

    public void deletaVeiculo(String placa) {
        boolean placaCadastrada = veiculoRepository.existsById(placa);
        if (!placaCadastrada) {
            throw new RegistroExistenteException();
        }
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(placa);
        Veiculo veiculo = veiculoOptional.get();
        if (veiculo.getQtdMultas() > 0){
            throw new VeiculoComMultasException();
        }
        veiculoRepository.deleteById(placa);
    }
    public Veiculo adicionarMulta(String placa) {
        Optional<Veiculo> veiculoOpt = veiculoRepository.findById(placa);
        if (veiculoOpt.isEmpty()) {
            throw new RegistroNaoEncontradoException();
        }
        Veiculo veiculo = veiculoOpt.get();
        int qtd = veiculo.getQtdMultas() + 1;
        veiculo.setQtdMultas(qtd);
        veiculo = veiculoRepository.save(veiculo);
        return veiculo;
    }
}
