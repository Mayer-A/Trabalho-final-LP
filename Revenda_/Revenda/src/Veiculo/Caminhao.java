package Veiculo;

public class Caminhao extends Veiculo {

    private int numeroEixos;
    private double capacidadeCarga;

    public Caminhao(int numeroEixos, double capacidadeCarga, String placa, String marca,
            String modelo, int anoFabricacao, double quilometragem, double valorBase)
            throws DadosInvalidosException {
        super(placa, marca, modelo, anoFabricacao, quilometragem, valorBase);
        if (numeroEixos < 2) {
            throw new DadosInvalidosException("Número de eixos inválido: " + numeroEixos);
        }
        if (capacidadeCarga <= 0) {
            throw new DadosInvalidosException("Capacidade de carga inválida: " + capacidadeCarga);
        }
        this.numeroEixos = numeroEixos;
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getNumeroEixos() {
        return numeroEixos;
    }

    public void setNumeroEixos(int numeroEixos) {
        this.numeroEixos = numeroEixos;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public double calcularPrecoVenda() {
        double valor = getValorBase() - calcularDepreciacao();

        // R$ 8.000 por eixo acima de 2
        if (numeroEixos > 2) {
            valor += (numeroEixos - 2) * 8000;
        }

        // acima de 500.000 km: desconto de 10%
        if (getQuilometragem() > 500000) {
            valor = valor * 0.90;
        }

        return valor;
    }

    @Override
    public String getTipo() {
        return "Caminhão";
    }
}
