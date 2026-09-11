package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    // Converte de DTO para MODEL (Útil para salvar/atualizar dados no banco)
    public MissaoModel map(MissoesDTO missoesDTO){
        MissaoModel missaoModel = new MissaoModel();

        missaoModel.setNome(missoesDTO.getNome());
        missaoModel.setDificuldade(missoesDTO.getDificuldade());
        missaoModel.setNinjas(missoesDTO.getNinjas());

        return missaoModel;
    }

    // Converte de MODEL para DTO (Útil para listar/buscar dados e enviar para a Controller)
    public MissoesDTO map(MissaoModel missaoModel){
        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missaoModel.getId());
        missoesDTO.setNome(missaoModel.getNome());
        missoesDTO.setDificuldade(missaoModel.getDificuldade());
        missoesDTO.setNinjas(missaoModel.getNinjas());

        return missoesDTO;
    }
}
