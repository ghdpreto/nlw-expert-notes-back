package br.com.ghdpreto.nlw_expert_notes_back.exceptions;

public class UsuarioEncontradoException extends RuntimeException {
    public UsuarioEncontradoException() {
        super("E-mail já existe.");
    }
}
