package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.ghdpreto.nlw_expert_notes_back.exceptions.dto.ExceptionErroDTO;
import br.com.ghdpreto.nlw_expert_notes_back.exceptions.dto.MensagemErroDTO;
import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.dto.NotaResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(tags = "Nota", summary = "Listar notas.", description = "Listar todas as notas vinculadas ao usuário.")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de notas", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = NotaResponseDTO.class)))),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MensagemErroDTO.class)))),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionErroDTO.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MensagemErroDTO.class)))
})
public @interface ListarNotaSwagger {
}
