package dev.java10x.CadastroDeNinjas.Ninjas.Model;

import dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

@Entity // transformanda a classe em um entidade de Database
@Table(name = "tb_cadastro") // nomeando a tabela do Database
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    /*
    * @ManyToOne -> um ninja para uma missão
    *       @JoinColumn -> name = coluna_relacionando-as_com_uma_Foreing_Key
    */
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

    public NinjaModel(){}

    public NinjaModel(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters e Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
