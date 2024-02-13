package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

import br.com.ghdpreto.nlw_expert_notes_back.exceptions.NaoEncontradoException;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.entities.UsuarioEntity;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.repositories.UsuarioRepository;

@Service
public class PerfilUsuarioUseCase {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity execute(@NonNull UUID id) {

        var usuario = this.usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            throw new NaoEncontradoException("Usuario");
        }

        return usuario.get();

    }
}
