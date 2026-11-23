package Veiculo;
public class Onibus extends Veiculo{
    private int numeroAssentos;
    private boolean rodovia;

    public Onibus(int numeroAssentos, boolean rodovia, String placa, String marca, String modelo, int anoFabricacao, double quilometragem, double valorBase) throws DadosInvalidosException{
        if (placa == "" || marca == "" || modelo == ""){
            throw new DadosInvalidosException();
        }
        if (numeroAssentos < 10 || numeroAssentos > 60) {
            throw new DadosInvalidosException("Número de assentos inválido: " + numeroAssentos);
        }
        super(placa, marca, modelo, anoFabricacao, quilometragem, valorBase);
        this.numeroAssentos = numeroAssentos;
        this.rodovia = rodovia;
    }

    public int getNumeroAssentos() {
        return numeroAssentos;
    }

    public void setNumeroAssentos(int numeroAssentos) {
        this.numeroAssentos = numeroAssentos;
    }

    public boolean isRodovia() {
        return rodovia;
    }

    public void setRodovia(boolean rodovia) {
        this.rodovia = rodovia;
    }
    
    public double calcularPrecoVenda(){
        double valor = super.getValorBase() - calcularDepreciacao();
        
        if (numeroAssentos >= 10 && numeroAssentos <= 60){
            double assentos = numeroAssentos * 300;
            valor = valor + assentos;
        }
        
        if (rodovia == true){
            valor = valor * 1.15;
        }
        
        return valor;
    }
    
    public String getTipo(){
        return "Onibus";
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nOnibus{");
        sb.append("\nPlaca=").append(super.getPlaca());
        sb.append("\nMarca=").append(super.getMarca());
        sb.append("\nModelo=").append(super.getModelo());
        sb.append("\nAno de fabricacao=").append(super.getAnoFabricacao());
        sb.append("\nQuilometragem=").append(super.getQuilometragem());
        sb.append("\nValor base=").append(super.getValorBase());
        sb.append("\nCalcular Preco=").append(calcularPrecoVenda());
        sb.append("\nNumero de assentos=").append(numeroAssentos);
        sb.append("\nRodovia=").append(rodovia);
        sb.append('}');
        return sb.toString();
    }
}
