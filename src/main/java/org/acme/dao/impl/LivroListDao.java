package org.acme.dao.impl;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.acme.dao.ILivroDao;
import org.acme.dao.entities.Livro;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named("livroListDao")
public class LivroListDao implements ILivroDao {

    private List<Livro> livros;

    public LivroListDao(){
        livros = new ArrayList<>();
    }


    public Uni<Livro> salvar(Livro livro){
        livros.add(livro);
        return Uni.createFrom().item(livro);
    }

    public Uni<List<Livro>> listarTodos(){
        return Uni.createFrom().item(livros);
    }
}
