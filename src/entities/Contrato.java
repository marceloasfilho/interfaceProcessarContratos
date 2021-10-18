package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
    private Integer numero;
    private Date data;
    private Double valor;
    private List<Parcela> parcelas;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Contrato(Integer numero, String data, Double valor) throws ParseException {
        this.numero = numero;
        this.data = sdf.parse(data);
        this.valor = valor;
        this.parcelas = new ArrayList<Parcela>();
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    public void adicionarParcela(Parcela parcela) {
        this.parcelas.add(parcela);
    }

    public void removerParcela(Parcela parcela) {
        this.parcelas.remove(parcela);
    }

    @Override
    public String toString() {
        String resultado =  "Contrato:" +
                "\nNúmero: " + this.numero +
                "\nData (dd/MM/yyyy): " + sdf.format(this.data) +
                "\nValor do Contrato: " + this.valor +
                "\nParcelas: \n";

        for (Parcela parcela: this.parcelas) {
            resultado = resultado + sdf.format(parcela.getData()) + " - " + parcela.getValor() + "\n";
        }
        return resultado;
    }
}
