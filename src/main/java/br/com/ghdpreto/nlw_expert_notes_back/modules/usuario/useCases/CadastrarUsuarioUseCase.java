package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghdpreto.nlw_expert_notes_back.exceptions.UsuarioEncontradoException;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto.CadastrarUsuarioDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.entities.UsuarioEntity;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.repositories.UsuarioRepository;

@Service
public class CadastrarUsuarioUseCase {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity execute(CadastrarUsuarioDTO dto) {
        this.usuarioRepository.findByEmail(dto.getEmail()).ifPresent((usuario) -> {
            throw new UsuarioEncontradoException();
        });

        UsuarioEntity novoUsuario = UsuarioEntity.builder()
                .email(dto.getEmail())
                .nome(dto.getNome())
                .password(dto.getSenha())
                .build();

        return this.usuarioRepository.save(novoUsuario);

    }
}
