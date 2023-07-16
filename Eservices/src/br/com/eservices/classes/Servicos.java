package br.com.eservices.classes;

import br.com.eservices.Interface.Isaldo;

public class Servicos implements Isaldo {

    private Double saldoServico;
    private Double valorServico;

    public Servicos(Double saldoServico, Double valorServico) {
        this.saldoServico = saldoServico;
        this.valorServico = valorServico;
    }

    public double getSaldoServico() {
        return saldoServico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void creditar(double valor) {
        saldoServico += valor;
    }

    @Override
    public void transferirDinheiro(double valor, Cliente origem, Servicos destino) {
        if (origem.getSaldo() >= valor) {
            origem.transferir(valor);
            destino.creditar(valor);
        } else {
            System.out.println("Saldo insuficiente. Você precisa ter " + (valor - origem.getSaldo()) + " a mais.");
        }
    }

    public double calcularValorTotal(int horas) {
        return valorServico * horas;
    }
}

