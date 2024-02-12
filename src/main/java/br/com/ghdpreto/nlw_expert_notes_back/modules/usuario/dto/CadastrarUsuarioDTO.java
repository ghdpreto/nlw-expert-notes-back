package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarUsuarioDTO {
    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9]).+$", message = "Deve conter um caracter especial, um numero e uma letra maiuscula.")
    @NotBlank
    private String senha;
}
