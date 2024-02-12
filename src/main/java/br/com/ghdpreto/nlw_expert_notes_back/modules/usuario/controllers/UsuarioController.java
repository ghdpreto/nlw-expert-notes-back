package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ghdpreto.nlw_expert_notes_back.exceptions.NaoEncontradoException;
import br.com.ghdpreto.nlw_expert_notes_back.exceptions.UsuarioEncontradoException;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto.CadastrarUsuarioDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto.PerfilUsuarioResponseDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases.CadastrarUsuarioUseCase;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases.PerfilUsuarioUseCase;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    @Autowired
    private PerfilUsuarioUseCase perfilUsuarioUseCase;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> perfil(@PathVariable UUID id) {

        try {
            var usuario = this.perfilUsuarioUseCase.execute(id);

            PerfilUsuarioResponseDTO response = PerfilUsuarioResponseDTO.builder()
                    .email(usuario.getEmail())
                    .nome(usuario.getNome())
                    .id(usuario.getId())
                    .build();

            return ResponseEntity.ok().body(response);

        } catch (NaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

}