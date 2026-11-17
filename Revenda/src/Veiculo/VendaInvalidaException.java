package Veiculo;
public class VendaInvalidaException extends RuntimeException{    
    public VendaInvalidaException(){
        super("ouve um erro chefe");
    }
    
    public VendaInvalidaException(String mensagem){
        super(mensagem);
    }
}
