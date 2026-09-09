package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Anotação RestController indica ao Springboot que esse é o controlador;
@RequestMapping("/ninjas") // Anotação para mapear as requisições
public class NinjaController {

    public NinjaService service;

    public NinjaController(NinjaService service) {
        this.service = service;
    }

    @GetMapping
    public String boasVindas(){
        return "Hello World!";
    }

    @PostMapping("/adicionar")
    public NinjaDTO create(@RequestBody NinjaDTO ninja){
        return service.create(ninja);
    }

    @GetMapping("/listar")
    public List<NinjaDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/listar/{id}")
    public Optional<NinjaDTO> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/atualizar/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return service.update(id, ninjaAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteNinja(Long id){
        service.delete(id);
    }
}
