package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<NinjaDTO> findAll() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::mapper)
                .collect(Collectors.toList());
    }

    public Optional<NinjaDTO> findById(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::mapper);
    }

    public NinjaDTO update(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaEncontrado = ninjaRepository.findById(id);

        if(ninjaEncontrado.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.mapper(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.mapper(ninjaSalvo);
        }
        return null;
    }

    public void delete(Long id) {
        ninjaRepository.deleteById(id);
    }

}
