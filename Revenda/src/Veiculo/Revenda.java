package Veiculo;

import java.util.ArrayList;
import java.util.List;

public class Revenda {
    private List<Veiculo> veiculos;

    public Revenda() {
        this.veiculos = new ArrayList<>();
    }

    public void cadastrar(Veiculo v) throws DadosInvalidosException {
        for (Veiculo existente : veiculos) {
            if (existente.getPlaca().equalsIgnoreCase(v.getPlaca())) {
                throw new DadosInvalidosException("Ja existe um veiculo " + v.getPlaca());
            }
        }
        veiculos.add(v);
    }

    public void vender(Veiculo v, double valorOferecido) throws VendaInvalidaException {
        if (v.isVendido()) {
            throw new VendaInvalidaException("Veiculo " + v.getPlaca() + " ja foi vendido");
        }
        double minimo = v.calcularPrecoVenda() * 0.9;
        if (valorOferecido < minimo) {
            throw new VendaInvalidaException("Proposta abaixo de 90% do preco do veiculo "
                    + v.getPlaca() + " (minimo: " + minimo + ")");
        }
        v.setVendido(true);
    }

    public List<Veiculo> getDisponiveis() {
        List<Veiculo> disponiveis = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (!v.isVendido()) {
                disponiveis.add(v);
            }
        }
        return disponiveis;
    }

    public double calcularValorEstoque() {
        double total = 0;
        for (Veiculo v : getDisponiveis()) {
            total += v.calcularPrecoVenda();
        }
        return total;
    }
}