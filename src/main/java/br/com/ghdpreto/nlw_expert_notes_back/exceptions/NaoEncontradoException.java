package br.com.ghdpreto.nlw_expert_notes_back.exceptions;

public class NaoEncontradoException extends RuntimeException {

    public NaoEncontradoException() {
        super("Dados não encontrado(s)");
    }

    /**
     * Cria uma nova instância da NaoEncontradoException com a mensagem
     * personalizada.
     * <dados> não encontrado(s).
     * 
     * @param dados Uma descrição do que nao foi localizado.
     */
    public NaoEncontradoException(String dados) {
        super(dados + " não encontrado(s).");
    }
}
