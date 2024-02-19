package br.com.ghdpreto.nlw_expert_notes_back.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionErroDTO {
    private String mensagem;
}
