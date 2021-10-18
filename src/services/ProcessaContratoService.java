package services;

import entities.Contrato;
import entities.Parcela;

import java.time.ZoneId;
import java.util.Date;

public class ProcessaContratoService {
    private Integer meses;
    private Contrato contrato;
    private PagamentoService servicoPagamento;

    public ProcessaContratoService(Integer meses, Contrato contrato, PagamentoService servicoPagamento) {
        this.meses = meses;
        this.contrato = contrato;
        this.servicoPagamento = servicoPagamento;
    }

    public Integer getMeses() {
        return meses;
    }

    public void setMeses(Integer meses) {
        this.meses = meses;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public PagamentoService getServicoPagamento() {
        return servicoPagamento;
    }

    public void setServicoPagamento(PagamentoService servicoPagamento) {
        this.servicoPagamento = servicoPagamento;
    }

    public void gerarRegistrosParcelas() {

        Double valorParcelaBase = this.contrato.getValor() / this.meses;

        for (int i = 0; i < meses; i++) {
            Date atual = this.contrato.getData();

            Date dataParcela = Date.from((atual.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate().plusMonths(i+1)).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

            Double valorParcela = this.servicoPagamento.aplicaPagamento(valorParcelaBase, (i + 1));

            Parcela parcelaAtual = new Parcela(dataParcela, valorParcela);
            this.contrato.adicionarParcela(parcelaAtual);
        }
    }
}
