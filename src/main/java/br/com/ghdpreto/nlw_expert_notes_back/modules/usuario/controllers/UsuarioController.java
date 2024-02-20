package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto.AtualizarUsuarioDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto.CadastrarUsuarioDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto.LoginUsuarioDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto.PerfilUsuarioResponseDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.entities.UsuarioEntity;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.swagger.AtualizarUsuarioSwagger;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.swagger.CadastrarUsuarioSwagger;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.swagger.LoginUsuarioSwagger;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.swagger.PerfilUsuarioSwagger;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases.AtualizarUsuarioUseCase;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases.CadastrarUsuarioUseCase;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases.LoginUsuarioUseCase;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases.PerfilUsuarioUseCase;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    @Autowired
    private PerfilUsuarioUseCase perfilUsuarioUseCase;

    @Autowired
    private AtualizarUsuarioUseCase atualizarUsuarioUseCase;

    @Autowired
    LoginUsuarioUseCase loginUsuarioUseCase;

    @PostMapping("login")
    @LoginUsuarioSwagger()
    public ResponseEntity<PerfilUsuarioResponseDTO> login(@RequestBody LoginUsuarioDTO dto) {

        Optional<UsuarioEntity> usuario = this.loginUsuarioUseCase.execute(dto.getEmail(), dto.getSenha());

        if (usuario.isPresent()) {
            PerfilUsuarioResponseDTO response = PerfilUsuarioResponseDTO.builder()
                    .email(usuario.get().getEmail())
                    .nome(usuario.get().getNome())
                    .id(usuario.get().getId())
                    .build();

            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping()
    @CadastrarUsuarioSwagger()
    public ResponseEntity<String> cadastrar(@Valid @RequestBody CadastrarUsuarioDTO dto) {
        var result = this.cadastrarUsuarioUseCase.execute(dto);

        // criando URI
        String uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.getId())
                .toUriString();

        return ResponseEntity.created(URI.create(uri)).build();

    }

    @GetMapping("/{id}")
    @PerfilUsuarioSwagger()
    public ResponseEntity<PerfilUsuarioResponseDTO> perfil(@PathVariable UUID id) {

        var usuario = this.perfilUsuarioUseCase.execute(id);

        PerfilUsuarioResponseDTO response = PerfilUsuarioResponseDTO.builder()
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .id(usuario.getId())
                .build();

        return ResponseEntity.ok().body(response);

    }

    @PatchMapping("/{id}")
    @AtualizarUsuarioSwagger()
    public ResponseEntity<String> atualizar(@PathVariable UUID id, @Valid @RequestBody AtualizarUsuarioDTO dto) {

        var response = this.atualizarUsuarioUseCase.execute(id, dto);

        System.out.println(response);
        return ResponseEntity.noContent().build();

    }
}