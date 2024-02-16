package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.dto.CriarNotaDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.dto.NotaResponseDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.entities.NotaEntity;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.swagger.CriarNotaSwagger;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.useCases.CadastrarNotaUseCase;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.useCases.ListarNotasUseCase;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private CadastrarNotaUseCase cadastrarNotaUseCase;

    @Autowired
    private ListarNotasUseCase listarNotasUseCase;

    @PostMapping()
    @CriarNotaSwagger()
    public ResponseEntity<NotaResponseDTO> criarNota(@Valid @RequestBody CriarNotaDTO body) {

        var resultado = this.cadastrarNotaUseCase.execute(body);

        NotaResponseDTO response = NotaResponseDTO.builder()
                .conteudo(resultado.getConteudo())
                .usuarioID(resultado.getUsuarioID())
                .dataCriacao(resultado.getDataCriacao())
                .id(resultado.getId())
                .build();

        return new ResponseEntity<NotaResponseDTO>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<NotaEntity>> listaPorUsuario(@PathVariable UUID idUsuario) {

        var response = this.listarNotasUseCase.execute(idUsuario);

        return new ResponseEntity<List<NotaEntity>>(response, HttpStatus.OK);
    }
}
