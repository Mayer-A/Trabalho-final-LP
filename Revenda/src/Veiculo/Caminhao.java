package Veiculo;
public class Caminhao extends Veiculo{
    private int numeroEixos;
    private double capacidadeCarga;

    public Caminhao(int numeroEixos, double capacidadeCarga, String placa, String marca, String modelo, int anoFabricacao, double quilometragem, double valorBase) throws DadosInvalidosException{
        if (placa == "" || marca == "" || modelo == ""){
            throw new DadosInvalidosException();
        }
        if (numeroEixos < 2){
            throw new DadosInvalidosException();
        }
        super(placa, marca, modelo, anoFabricacao, quilometragem, valorBase);
        this.numeroEixos = numeroEixos;
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getNumeroEixos() {
        return numeroEixos;
    }

    public void setNumeroEixos(int numeroEixos) {
        this.numeroEixos = numeroEixos;
    }

    public double getCapacacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacacidadeCarga(double capacacidadeCarga) {
        this.capacidadeCarga = capacacidadeCarga;
    }

    public double calcularPrecoVenda(){
        double valor = super.getValorBase() - calcularDepreciacao();
        
        if (numeroEixos > 2) {
            valor += (numeroEixos - 2) * 8000;
        }
        
        if (super.getQuilometragem() > 500000){
            valor = valor * 0.90;
        }
        
        return valor;
    }
    
    public String getTipo(){
        return "Caminhao";
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nCaminhao{");
        sb.append("\nPlaca=").append(super.getPlaca());
        sb.append("\nMarca=").append(super.getMarca());
        sb.append("\nModelo=").append(super.getModelo());
        sb.append("\nAno de fabricacao=").append(super.getAnoFabricacao());
        sb.append("\nQuilometragem=").append(super.getQuilometragem());
        sb.append("\nValor base=").append(super.getValorBase());
        sb.append("\nCalcular Preco=").append(calcularPrecoVenda());
        sb.append("\nNumero de eixos=").append(numeroEixos);
        sb.append("\nCapacidade=").append(capacidadeCarga);
        sb.append('}');
        return sb.toString();
    }
    
    
}
