package org.acme.api;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.acme.api.dtos.LivroDTO;
import org.acme.dao.entities.Livro;
import org.acme.service.ILivroService;
import org.acme.service.impl.LivroService;

import java.util.List;

@Path("livro")
@ApplicationScoped
public class LivroAPI {

    private ILivroService livroService;

    @Inject
    public LivroAPI(LivroService livroService){
        this.livroService = livroService;
    }


    @PUT
    public Response salvarLivro(LivroDTO livroDTO){

        livroService.salvarLivro(Livro.builder()
                .ano(livroDTO.getAno())
                .autor(livroDTO.getAutor())
                .titulo(livroDTO.getTitulo())
                .build());
        return Response.status(Response.Status.CREATED)
                .build();
    }

    @GET
    public Uni<List<Livro>> listarTodos(){
        return livroService.listarTodos();
    }
}
