package br.com.ghdpreto.nlw_expert_notes_back.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.ghdpreto.nlw_expert_notes_back.exceptions.dto.MensagemErroDTO;

@ControllerAdvice
public class ExceptionHandlerController {

    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MensagemErroDTO>> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception) {

        // gerando uma novo array
        List<MensagemErroDTO> response = new ArrayList<MensagemErroDTO>();

        exception.getBindingResult()
                .getFieldErrors().forEach(err -> {
                    String mensagem = messageSource.getMessage(err, LocaleContextHolder.getLocale());
                    MensagemErroDTO erro = new MensagemErroDTO(mensagem, err.getField());

                    response.add(erro);
                });

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
