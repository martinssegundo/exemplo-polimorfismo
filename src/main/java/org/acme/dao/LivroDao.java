package org.acme.dao;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dao.entities.Livro;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class LivroDao {

    private List<Livro> livros;

    public LivroDao(){
        livros = new ArrayList<>();
    }


    public void salvar(Livro livro){
        livros.add(livro);
    }

    public List<Livro> listarTodos(){
        return livros;
    }
}
