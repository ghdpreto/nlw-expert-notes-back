package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaDTO {
    @NotBlank
    private String conteudo;

    @NotNull(message = "Campo deve ser um UUID valido.")
    private UUID idUsuario;
}
