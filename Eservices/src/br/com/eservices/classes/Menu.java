package br.com.eservices.classes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void menuI() {
        System.out.println("BEM VINDO A ESERVICES "
   	          + "\nSelecione um serviço:"
                + "\n1. Faxina: R$ 100"
                + "\n2. Cozinhar:  R$ 150"
                + "\n3. Faxina e Cozinhar: R$ 220"
                + "\n4. Fechar Programa");
    }
    
    }

