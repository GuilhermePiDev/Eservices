package br.com.eservices.classes;

import java.util.Scanner;

import br.com.eservices.Interface.Isaldo;

public class Cliente implements Isaldo {

    private double saldo;

    public Cliente(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void transferir(double valor) {
        saldo -= valor;
        System.out.println("Transferência de " + valor + " realizada com sucesso.");
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
}

