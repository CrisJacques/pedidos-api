package com.example.produtosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@ToString
@Entity
// @Table(name = "nome_tabela") - só é necessário se o nome da tabela no banco de dados não for o mesmo da entidade
public class Product {

    @Id
    @GeneratedValue
    @UuidGenerator
    // @Column(name = "codigo") - só é necessário se o nome do atributo não fosse o mesmo da coluna no banco de dados
    private String id;

    private String name;
    private String description;
    private Double price;

}
