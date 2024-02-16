package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class NotaResponseDTO {
    private UUID id;
    private UUID usuarioID;
    private String conteudo;
    private LocalDateTime dataCriacao;
}
