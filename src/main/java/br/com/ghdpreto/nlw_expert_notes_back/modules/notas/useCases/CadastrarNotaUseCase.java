package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.dto.NotaDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.entities.NotaEntity;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.repositories.NotaRepository;

@Service
public class CadastrarNotaUseCase {

    @Autowired
    private NotaRepository notaRepository;

    public NotaEntity execute(NotaDTO notaDTO) {

        NotaEntity novaNota = NotaEntity.builder().conteudo(notaDTO.getConteudo()).build();

        return this.notaRepository.save(novaNota);
    }
}
