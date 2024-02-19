package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghdpreto.nlw_expert_notes_back.exceptions.NaoEncontradoException;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.repositories.NotaRepository;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases.PerfilUsuarioUseCase;

@Service
public class DeletarNotaUseCase {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private PerfilUsuarioUseCase perfilUsuarioUseCase;

    public void execute(UUID idUsuario, UUID idNota) {

        this.perfilUsuarioUseCase.execute(idUsuario);

        var nota = this.notaRepository.findById(idNota);

        if (nota.isEmpty()) {
            throw new NaoEncontradoException("Nota");
        }

        if (!nota.get().getUsuarioID().equals(idUsuario)) {
            throw new NaoEncontradoException("Nota");
        }

        this.notaRepository.deleteById(idNota);
    }
}
