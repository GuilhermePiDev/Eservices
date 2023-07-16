package br.com.eservices.Main;

import br.com.eservices.classes.Cliente;
import br.com.eservices.classes.Menu;
import br.com.eservices.classes.Servicos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean repet = false;
        Cliente cliente = new Cliente(500.0);
        Servicos faxina = new Servicos(0.0, 100.0);
        Servicos cozinhar = new Servicos(0.0, 150.0);
        Servicos ambos = new Servicos(0.0, 220.0);
        Menu menu = new Menu();

        while (!repet) {
            menu.menuI();
            Scanner scanner = new Scanner(System.in);
            int opcao = lerOpcaoMenu(scanner);

            if (opcao == 4) {
                System.out.println("Programa Encerrado");
                System.exit(0);
            }

            System.out.println("Informe a duração do serviço (em horas):");
            int horasServico = 0;
            boolean horasValidas = false;

            while (!horasValidas) {
                try {
                    horasServico = lerHorasServico(scanner);
                    if (horasServico < 1 || horasServico > 13) {
                        System.out.println("Informe um valor entre 1 e 13 para a duração do serviço.");
                    } else {
                        horasValidas = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido. Informe um número inteiro.");
                }
            }

            switch (opcao) {
                case 1:
                    double valorTotalFaxina = faxina.calcularValorTotal(horasServico);
                    double valorTransferencia = valorTotalFaxina;
                    cliente.transferirDinheiro(valorTransferencia, cliente, faxina);
                    break;
                case 2:
                    double valorTotalCozinhar = cozinhar.calcularValorTotal(horasServico);
                    valorTransferencia = valorTotalCozinhar;
                    cliente.transferirDinheiro(valorTransferencia, cliente, cozinhar);
                    break;
                case 3:
                    double valorTotalAmbos = ambos.calcularValorTotal(horasServico);
                    valorTransferencia = valorTotalAmbos;
                    cliente.transferirDinheiro(valorTransferencia, cliente, ambos);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

            System.out.println("Saldo do cliente: " + cliente.getSaldo() + "\nSaldo do serviço de faxina: "
                    + faxina.getSaldoServico() + "\nSaldo do serviço de cozinha: " + cozinhar.getSaldoServico()
                    + "\nSaldo do serviço de faxina e cozinha: " + ambos.getSaldoServico()
                    + "\n================================================\n");
        }
    }

    public static int lerOpcaoMenu(Scanner scanner) {
        int opcao = -1;
        boolean inputValido = false;

        while (!inputValido) {
            try {
                opcao = scanner.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Informe um número inteiro.");
                scanner.nextLine();
            }
        }

        return opcao;
    }

    public static int lerHorasServico(Scanner scanner) {
        int horas = -1;
        boolean inputValido = false;

        while (!inputValido) {
            try {
                horas = scanner.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Informe um número inteiro.");
                scanner.nextLine();
            }
        }

        return horas;
    }
}


