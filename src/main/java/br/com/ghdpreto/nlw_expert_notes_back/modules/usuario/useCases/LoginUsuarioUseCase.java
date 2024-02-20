package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.entities.UsuarioEntity;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.repositories.UsuarioRepository;

@Service
public class LoginUsuarioUseCase {
    @Autowired
    public UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> execute(String email, String senha) {

        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findByEmail(email);

        if (usuarioOptional.isPresent()) {
            UsuarioEntity usuario = usuarioOptional.get();

            if (usuario.getPassword().equals(senha)) {
                return usuarioOptional;
            }
        }

        return Optional.empty();
    }
}
