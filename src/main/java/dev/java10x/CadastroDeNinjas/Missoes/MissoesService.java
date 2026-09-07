package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private final MissoesRepository repository;

    public MissoesService(MissoesRepository repository) {
        this.repository = repository;
    }

    public MissaoModel create(MissaoModel missaoCriada) {
        return repository.save(missaoCriada);
    }

    public List<MissaoModel> findAll(){
        return repository.findAll();
    }

    public Optional<MissaoModel> findById(Long id){
        return repository.findById(id);
    }

    public MissaoModel updade(Long id, MissaoModel missaoAtualizada){
        Optional<MissaoModel> missaoEncontrada = repository.findById(id);
        missaoEncontrada.map(missao -> {
            missao.setNome(missaoAtualizada.getNome());
            missao.setDificuldade(missaoAtualizada.getDificuldade());
            return repository.save(missao);
        });
        return null;
    }
}
