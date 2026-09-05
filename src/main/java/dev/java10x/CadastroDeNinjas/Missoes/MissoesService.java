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
}
