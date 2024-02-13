package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.useCases;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto.AtualizarUsuarioDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.entities.UsuarioEntity;
import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.repositories.UsuarioRepository;

@Service
public class AtualizarUsuarioUseCase {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilUsuarioUseCase perfilUsuarioUseCase;

    public UsuarioEntity execute(UUID id, AtualizarUsuarioDTO dto) {

        UsuarioEntity usuario = this.perfilUsuarioUseCase.execute(id);

        // atualiza somente os campos enviados
        BeanUtils.copyProperties(dto, usuario);

        return this.usuarioRepository.save(usuario);
    }
}
