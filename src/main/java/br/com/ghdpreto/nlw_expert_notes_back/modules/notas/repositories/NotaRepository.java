package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.entities.NotaEntity;

@Repository
public interface NotaRepository extends JpaRepository<NotaEntity, UUID> {

}
