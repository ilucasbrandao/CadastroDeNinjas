package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    public MissoesService service;

    public MissoesController(MissoesService service) {
        this.service = service;
    }

    @PostMapping("/criar")
    public MissaoModel create(@RequestBody MissaoModel missao){
        return service.create(missao);
    }

    @GetMapping("/listar")
    public List<MissaoModel> findAll(){
        return service.findAll();
    }

    @GetMapping("/listar/{id}")
    public Optional<MissaoModel> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/atualizar/{id}")
    public MissaoModel update(@PathVariable Long id, @RequestBody MissaoModel missaoAtualizada){
        return service.updade(id, missaoAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
