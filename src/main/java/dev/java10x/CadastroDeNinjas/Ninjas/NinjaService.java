package dev.java10x.CadastroDeNinjas.Ninjas.Service;

import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaMapper;
import dev.java10x.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public NinjaDTO create(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.mapper(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.mapper(ninja);
    }

    public List<NinjaModel> findAll() {
        return ninjaRepository.findAll();
    }

    public Optional<NinjaModel> findById(Long id){
        return ninjaRepository.findById(id);
    }

    public NinjaModel update(Long id, NinjaModel ninjaAtualizado) {
        Optional<NinjaModel> ninjaEncontrado = ninjaRepository.findById(id);
        ninjaEncontrado.map( ninja -> {
            ninja.setName(ninjaAtualizado.getName());
            ninja.setAge(ninjaAtualizado.getAge());
            ninja.setEmail(ninjaAtualizado.getEmail());
            return ninjaRepository.save(ninja);
        });
        return null;
    }

    public void delete(Long id) {
        ninjaRepository.deleteById(id);
    }

}
