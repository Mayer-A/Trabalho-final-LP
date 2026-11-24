package Veiculo;

public class Onibus extends Veiculo {

    private int numeroAssentos;
    private boolean rodovia;

    public Onibus(int numeroAssentos, boolean rodovia, String placa, String marca,
            String modelo, int anoFabricacao, double quilometragem, double valorBase)
            throws DadosInvalidosException {
        super(placa, marca, modelo, anoFabricacao, quilometragem, valorBase);
        if (numeroAssentos < 10 || numeroAssentos > 60) {
            throw new DadosInvalidosException("Número de assentos inválido: " + numeroAssentos);
        }
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

    @Override
    public double calcularPrecoVenda() {
        double valor = getValorBase() - calcularDepreciacao();

        // R$ 300 por assento
        valor += numeroAssentos * 300;

        // ônibus rodoviário: +15%
        if (rodovia) {
            valor = valor * 1.15;
        }

        return valor;
    }

    @Override
    public String getTipo() {
        return "Ônibus";
    }
}
