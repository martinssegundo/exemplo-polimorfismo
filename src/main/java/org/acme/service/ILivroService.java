package org.acme.service;

import io.smallrye.mutiny.Uni;
import org.acme.dao.entities.Livro;

import java.util.List;

public interface ILivroService {
    Uni<Livro> salvarLivro(Livro livro);


    Uni<List<Livro>> listarTodos();
}
