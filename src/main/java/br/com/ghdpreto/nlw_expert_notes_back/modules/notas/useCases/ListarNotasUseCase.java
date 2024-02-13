package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.useCases;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.entities.NotaEntity;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.repositories.NotaRepository;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases.PerfilUsuarioUseCase;
import lombok.NonNull;

@Service
public class ListarNotasUseCase {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private PerfilUsuarioUseCase perfilUsuarioUseCase;

    public List<NotaEntity> execute(@NonNull UUID idUsuario) {

        this.perfilUsuarioUseCase.execute(idUsuario);

        var result = this.notaRepository.findByUsuarioID(idUsuario);

        return result;
    }
}
