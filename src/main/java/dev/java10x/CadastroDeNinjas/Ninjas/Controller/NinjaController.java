package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.Service.NinjaService;
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
    public NinjaModel create(NinjaModel ninja){
        return service.create(ninja);
    }

    @GetMapping("/listar")
    public List<NinjaModel> findAll(){
        return service.findAll();
    }

    @GetMapping("/listar/{id}")
    public Optional<NinjaModel> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/atualizar")
    public String atualizarNinja(){
        return "Alterar Ninja por ID.";
    }

    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
        return "Deletando Ninja por ID.";
    }
}
