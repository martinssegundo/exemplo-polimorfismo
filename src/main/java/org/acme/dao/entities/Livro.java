package org.acme.dao.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RegisterForReflection
public class Livro extends PanacheEntity {
    private String autor;
    private String titulo;
    private String ano;
}
