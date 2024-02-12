package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.entities.NotaEntity;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.repositories.NotaRepository;

@Service
public class ListarNotasUseCase {

    @Autowired
    private NotaRepository notaRepository;

    public List<NotaEntity> execute() {

        var result = this.notaRepository.findAll();

        return result;
    }
}
