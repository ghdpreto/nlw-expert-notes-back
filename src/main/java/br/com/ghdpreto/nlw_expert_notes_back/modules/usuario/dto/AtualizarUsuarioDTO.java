package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AtualizarUsuarioDTO {
    private String nome;

    @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9]).+$", message = "Deve conter um caracter especial, um numero e uma letra maiuscula.")
    private String senha;
}
