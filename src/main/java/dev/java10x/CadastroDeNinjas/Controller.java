package dev.java10x.CadastroDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Anotação RestController indica ao Springboot que esse é o controlador;
@RequestMapping // Anotação para mapear as requisições
public class Controller {

    @GetMapping
    public String boasVindas(){
        return "Hello World!";
    }
}
