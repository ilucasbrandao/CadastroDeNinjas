package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository repository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository repository, MissoesMapper missoesMapper) {
        this.repository = repository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO create(MissoesDTO missoesDTO) {
        MissaoModel missaoCriada = missoesMapper.map(missoesDTO);
        missaoCriada = repository.save(missaoCriada);
        return missoesMapper.map(missaoCriada);
    }

    public List<MissoesDTO> findAll(){
        List<MissaoModel> missoes = repository.findAll(); // Cria as missões em uma variável
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<MissoesDTO> findById(Long id){
        Optional<MissaoModel> missaoPorId = repository.findById(id);
        return missaoPorId.map(missoesMapper::map); // Mapeia a missão encontrada
    }

    public MissoesDTO update(Long id, MissoesDTO missoesDTO){
        Optional<MissaoModel> missaoEncontrada = repository.findById(id);

        if(missaoEncontrada.isPresent()){
            MissaoModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissaoModel missaoSalva = repository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }

        return null;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
