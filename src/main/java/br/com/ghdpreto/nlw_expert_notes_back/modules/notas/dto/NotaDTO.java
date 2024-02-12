package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaDTO {
    @NotBlank
    private String conteudo;
}
