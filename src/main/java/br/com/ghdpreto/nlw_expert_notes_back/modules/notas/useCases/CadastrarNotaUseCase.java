package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.dto.NotaDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.entities.NotaEntity;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.repositories.NotaRepository;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases.PerfilUsuarioUseCase;

@Service
public class CadastrarNotaUseCase {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private PerfilUsuarioUseCase perfilUsuarioUseCase;

    public NotaEntity execute(NotaDTO notaDTO) {

        this.perfilUsuarioUseCase.execute(notaDTO.getIdUsuario());

        NotaEntity novaNota = NotaEntity.builder()
                .usuarioID(notaDTO.getIdUsuario())
                .conteudo(notaDTO.getConteudo())
                .build();

        return this.notaRepository.save(novaNota);
    }
}
