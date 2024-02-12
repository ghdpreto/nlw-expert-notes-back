package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

    public Optional<UsuarioEntity> findByEmail(String email);
}
