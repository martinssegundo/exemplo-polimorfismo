package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dao.LivroDao;
import org.acme.dao.entities.Livro;

import java.util.List;

@ApplicationScoped
public class LivroService {

    private LivroDao livroDao;

    @Inject
    public LivroService(LivroDao livroDao){
        this.livroDao = livroDao;
    }

    public void salvarLivro(Livro livro) {
        livroDao.salvar(livro);
    }


    public List<Livro> listarTodos() {
        return livroDao.listarTodos();
    }
}
