package dev.java10x.CadastroDeNinjas.Ninjas.Model;

import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // transformanda a classe em um entidade de Database
@Table(name = "tb_cadastro") // nomeando a tabela do Database

/*
* Lombok
* - cria os construtores (com e sem argumentos), mesmo adicionando novos atributos
* - @Data -> essa anotação cria os getters e setters automaticamente
*/

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_ninja")
    private String name;

    @Column(name = "age_ninja")
    private Integer age;

    @Column(unique = true)
    private String email;

    /*
     * @ManyToOne -> um ninja para uma missão
     *       @JoinColumn -> name = coluna_relacionando-as_com_uma_Foreing_Key
     */
    @ManyToOne
    @JoinColumn(name = "missoes_id")  // Foreing Key
    private MissaoModel missoes;
}
