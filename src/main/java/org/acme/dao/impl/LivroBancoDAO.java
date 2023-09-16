package org.acme.dao.impl;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.acme.dao.ILivroDao;
import org.acme.dao.entities.Livro;

import java.util.List;

@ApplicationScoped
@Named("livroBancoDAO")
public class LivroBancoDAO implements ILivroDao {
    @Override
    public Uni<Livro> salvar(Livro livro) {
        return livro.persistAndFlush();
    }

    @Override
    public Uni<List<Livro>> listarTodos() {
        return Livro.findAll().list();
    }
}
