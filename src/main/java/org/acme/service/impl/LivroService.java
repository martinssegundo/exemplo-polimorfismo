package org.acme.service.impl;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.acme.dao.ILivroDao;
import org.acme.dao.entities.Livro;
import org.acme.dao.impl.LivroBancoDAO;
import org.acme.service.ILivroService;

import java.util.List;

@ApplicationScoped
public class LivroService implements ILivroService {

    private LivroBancoDAO livroListDao;

    @Inject
    public LivroService(@Named("livroBancoDAO") LivroBancoDAO livroBancoDAO){
        this.livroListDao = livroBancoDAO;
    }

    @WithSession
    public Uni<Void> salvarLivro(Livro livro) {
        return livroListDao.salvar(livro);
    }


    public Uni<List<Livro>> listarTodos() {
        return livroListDao.listarTodos();
    }
}
