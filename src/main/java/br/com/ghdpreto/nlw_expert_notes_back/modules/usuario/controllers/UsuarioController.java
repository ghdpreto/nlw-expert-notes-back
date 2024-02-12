package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ghdpreto.nlw_expert_notes_back.exceptions.UsuarioEncontradoException;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto.CadastrarUsuarioDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases.CadastrarUsuarioUseCase;
import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    @PostMapping()
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody CadastrarUsuarioDTO dto) {
        try {
            var result = this.cadastrarUsuarioUseCase.execute(dto);

            // criando URI
            String uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(result.getId())
                    .toUriString();
            return ResponseEntity.created(URI.create(uri)).build();
        } catch (UsuarioEncontradoException e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}