package io.github.rhuann.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE")  //não é necessario usar essa anotação se a classe tiver o mesmo nome da tabela
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") //não é necessario usar essa anotação se a coluna tiver o mesmo nome desse campo
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    public Cliente() {

    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
