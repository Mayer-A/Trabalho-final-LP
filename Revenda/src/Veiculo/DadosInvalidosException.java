package Veiculo;
public class DadosInvalidosException extends RuntimeException{    
    public DadosInvalidosException(){
        super("ouve um erro chefe");
    }
    
    public DadosInvalidosException(String mensagem){
        super(mensagem);
    }
}
