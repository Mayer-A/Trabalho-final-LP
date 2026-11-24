package Veiculo;

import java.util.ArrayList;
import java.util.List;

public class Revenda {

    private final List<Veiculo> veiculos;

    public Revenda() {
        this.veiculos = new ArrayList<>();
    }

    public void cadastrar(Veiculo v) throws DadosInvalidosException {
        for (Veiculo existente : veiculos) {
            if (existente.getPlaca().equalsIgnoreCase(v.getPlaca())) {
                throw new DadosInvalidosException(
                        "Já existe um veículo com a placa " + v.getPlaca());
            }
        }
        veiculos.add(v);
    }

    public void vender(Veiculo v, double valorOferecido) throws VendaInvalidaException {
        if (v.isVendido()) {
            throw new VendaInvalidaException("Veículo " + v.getPlaca() + " já foi vendido");
        }
        double minimo = v.calcularPrecoVenda() * 0.9;
        if (valorOferecido < minimo) {
            throw new VendaInvalidaException(
                    "Proposta abaixo de 90% do preço do veículo " + v.getPlaca());
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
