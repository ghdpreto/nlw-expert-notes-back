package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUsuarioDTO {
    @NotBlank
    private String email;

    @NotBlank
    private String senha;
}
