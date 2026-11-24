package Veiculo;

public class DadosInvalidosException extends Exception {

    public DadosInvalidosException() {
        super("Dados inválidos");
    }

    public DadosInvalidosException(String mensagem) {
        super(mensagem);
    }
}
