package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerfilUsuarioResponseDTO {
    private UUID id;
    private String nome;
    private String email;
}
