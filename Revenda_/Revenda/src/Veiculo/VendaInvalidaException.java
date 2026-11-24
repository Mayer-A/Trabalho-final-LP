package Veiculo;

public class VendaInvalidaException extends Exception {

    public VendaInvalidaException() {
        super("Venda inválida");
    }

    public VendaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
