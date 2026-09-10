package dev.java10x.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    /*
    * @OneToMany -> Uma missão para muitos Ninjas
    *     Foreign key -> mappadBy = "nome_da_coluna_relacionada"
    */
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore // Essa anotação ignora a serialização que ocorre e gera um loop infinito
    private List<NinjaModel> ninjas;
}
