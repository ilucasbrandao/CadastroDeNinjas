package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    public MissoesService service;

    public MissoesController(MissoesService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<MissaoModel> findAll(){
        return service.findAll();
    }

    @GetMapping("/listar/{id}")
    public Optional<MissaoModel> findById(@PathVariable Long id){
        return service.findById(id);
    }

}
