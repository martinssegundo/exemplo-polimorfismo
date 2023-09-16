package org.acme.dao;

import io.smallrye.mutiny.Uni;
import org.acme.dao.entities.Livro;

import java.util.List;

public interface ILivroDao {

    Uni<Void> salvar(Livro livro);

    Uni<List<Livro>> listarTodos();
}
