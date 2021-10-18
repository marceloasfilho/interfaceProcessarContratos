package services;

public class PayPalPagamentoService implements PagamentoService {

    private Double juros = 0.01;
    private Double taxa = 0.02;

    public Double getJuros() {
        return juros;
    }

    public Double getTaxa() {
        return taxa;
    }

    @Override
    public Double aplicaPagamento(Double valorParcela, Integer mes) {
        Double total = valorParcela + (valorParcela * this.juros * mes);
        return total + (total * this.taxa);
    }
}
