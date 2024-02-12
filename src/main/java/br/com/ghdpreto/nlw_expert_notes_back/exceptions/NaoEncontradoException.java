package br.com.ghdpreto.nlw_expert_notes_back.exceptions;

public class NaoEncontradoException extends RuntimeException {

    public NaoEncontradoException() {
        super("Dados não encontrados.");
    }
}
