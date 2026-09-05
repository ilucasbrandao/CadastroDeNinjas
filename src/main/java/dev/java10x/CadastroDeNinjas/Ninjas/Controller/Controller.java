package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Anotação RestController indica ao Springboot que esse é o controlador;
@RequestMapping // Anotação para mapear as requisições
public class Controller {

    @GetMapping
    public String boasVindas(){
        return "Hello World!";
    }

    @PostMapping("/adicionar")
    public String criarNinja(){
        return "Ninja criado";
    }

    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrando os ninjas.";
    }

    @GetMapping("/porId")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrando o ninja por ID.";
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
