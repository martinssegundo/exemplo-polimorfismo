package org.acme.dao.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Livro extends PanacheEntity {
    private String autor;
    private String titulo;
    private String ano;
}
