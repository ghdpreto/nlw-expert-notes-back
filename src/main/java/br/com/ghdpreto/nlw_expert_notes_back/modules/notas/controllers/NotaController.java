package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.dto.NotaDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.entities.NotaEntity;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.useCases.CadastrarNotaUseCase;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.useCases.ListarNotasUseCase;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<NotaEntity> criarNota(@Valid @RequestBody NotaDTO body) {
        var response = this.cadastrarNotaUseCase.execute(body);

        return new ResponseEntity<NotaEntity>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<NotaEntity>> listarTodas() {

        var response = this.listarNotasUseCase.execute();

        return new ResponseEntity<List<NotaEntity>>(response, HttpStatus.OK);
    }
}
