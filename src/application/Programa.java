package application;

import entities.Contrato;
import services.PayPalPagamentoService;
import services.ProcessaContratoService;

import java.text.ParseException;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Contrato contrato = new Contrato(8028, "25/07/2018", 600.00);

        ProcessaContratoService processaContratoService = new ProcessaContratoService(3, contrato, new PayPalPagamentoService());
        processaContratoService.gerarRegistrosParcelas();

        System.out.println(contrato.toString());
    }
}
