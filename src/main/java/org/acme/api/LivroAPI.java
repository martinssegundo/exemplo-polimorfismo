package org.acme.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.acme.api.dtos.LivroDTO;
import org.acme.service.LivroService;

@Path("livro")
@ApplicationScoped
public class LivroAPI {

    private LivroService livroService;

    @Inject
    public LivroAPI(LivroService livroService){
        this.livroService = livroService;
    }


    @PUT
    public Response salvbarLivro(LivroDTO livroDTO){
        return Response.status(Response.Status.CREATED)
                .entity(LivroDTO.builder().build())
                .build();
    }
}
