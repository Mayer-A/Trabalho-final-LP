package Veiculo;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Veiculo {

    public static final int ANO_ATUAL = 2026;
    private static final int ANO_MINIMO = 1900;

    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private double quilometragem;
    private double valorBase;
    private boolean vendido;

    public Veiculo(String placa, String marca, String modelo, int anoFabricacao,
            double quilometragem, double valorBase) throws DadosInvalidosException {
        if (placa == null || placa.isBlank()) {
            throw new DadosInvalidosException("A placa é obrigatória");
        }
        if (marca == null || marca.isBlank()) {
            throw new DadosInvalidosException("A marca é obrigatória");
        }
        if (modelo == null || modelo.isBlank()) {
            throw new DadosInvalidosException("O modelo é obrigatório");
        }
        if (anoFabricacao < ANO_MINIMO || anoFabricacao > ANO_ATUAL) {
            throw new DadosInvalidosException("Ano de fabricação inválido: " + anoFabricacao);
        }
        if (quilometragem < 0) {
            throw new DadosInvalidosException("Quilometragem inválida: " + quilometragem);
        }
        if (valorBase <= 0) {
            throw new DadosInvalidosException("Valor base inválido: " + valorBase);
        }
        this.placa = placa.trim();
        this.marca = marca.trim();
        this.modelo = modelo.trim();
        this.anoFabricacao = anoFabricacao;
        this.quilometragem = quilometragem;
        this.valorBase = valorBase;
        this.vendido = false;
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

    /** 5% do valor base por ano de idade, limitado a 50% do valor base. */
    public double calcularDepreciacao() {
        int idade = ANO_ATUAL - anoFabricacao;
        double depreciacao = valorBase * 0.05 * idade;
        double limite = valorBase * 0.50;
        return Math.min(depreciacao, limite);
    }

    public abstract double calcularPrecoVenda();

    public abstract String getTipo();

    public static String formatarMoeda(double valor) {
        return NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(valor);
    }

    @Override
    public String toString() {
        return getTipo() + " · " + placa + " · " + marca + " " + modelo
                + " (" + anoFabricacao + ") · " + formatarMoeda(calcularPrecoVenda());
    }
}
