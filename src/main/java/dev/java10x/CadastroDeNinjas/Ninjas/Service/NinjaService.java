package dev.java10x.CadastroDeNinjas.Ninjas.Service;

import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository repository;

    public NinjaService(NinjaRepository repository) {
        this.repository = repository;
    }

    public NinjaModel create(NinjaModel ninjaModel){
        return repository.save(ninjaModel);
    }

    public List<NinjaModel> findAll() {
        return repository.findAll();
    }

    public Optional<NinjaModel> findById(Long id){
        return repository.findById(id);
    }

    public NinjaModel update(Long id, NinjaModel ninjaAtualizado) {
        Optional<NinjaModel> ninjaEncontrado = repository.findById(id);
        ninjaEncontrado.map( ninja -> {
            ninja.setName(ninjaAtualizado.getName());
            ninja.setAge(ninjaAtualizado.getAge());
            ninja.setEmail(ninjaAtualizado.getEmail());
            return repository.save(ninja);
        });
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
