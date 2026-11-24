package Veiculo;
abstract class Veiculo extends Revenda{
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private double quilometragem;
    private double valorBase;
    private boolean vendido;

    public Veiculo(String placa, String marca, String modelo, int anoFabricacao, double quilometragem, double valorBase) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.quilometragem = quilometragem;
        this.valorBase = valorBase;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
    
    public double calcularDepreciacao(){
    
        double depreciacao = valorBase * 0.05 * anoFabricacao;
        double limite =  valorBase * 0.50;
        
        if (depreciacao > limite) {
            return limite;
        }
        
        return depreciacao;
    }
    
    abstract double calcularPrecoVenda();
    
    abstract String getTipo();    
}
