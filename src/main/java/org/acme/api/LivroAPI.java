package org.acme.api;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;
import org.acme.api.dtos.LivroDTO;
import org.acme.dao.entities.Livro;
import org.acme.service.ILivroService;
import org.acme.service.impl.LivroService;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("livro")
@ApplicationScoped
@Slf4j
public class LivroAPI {

    private ILivroService livroService;

    @Inject
    public LivroAPI(LivroService livroService) {
        this.livroService = livroService;
    }


    @PUT
    public Uni<RestResponse<Livro>> salvarLivro(LivroDTO livroDTO) {

        return Uni.createFrom().item(() -> {
            livroService.salvarLivro(Livro.builder()
                    .ano(livroDTO.getAno())
                    .autor(livroDTO.getAutor())
                    .titulo(livroDTO.getTitulo())
                    .build())
                    .subscribe()
                    .with(item -> log.debug("Finish to sabe a book"));
            return RestResponse.status(HttpResponseStatus.CREATED.code());
        });
    }

    @GET
    public Uni<List<Livro>> listarTodos() {
        return livroService.listarTodos();
    }
}
