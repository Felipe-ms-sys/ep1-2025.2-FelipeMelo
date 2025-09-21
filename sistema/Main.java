package Projeto1Poo.sistema;
import Projeto1Poo.entidades.*;
import java.util.Scanner;


public class Main{
    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do{
            Menus.MenuPrincipal();
            opcao = scanner.nextInt();

            switch (opcao) {
            case 0:
                System.out.println("Fechando Sistema");
                break; 

            case 1:
                System.out.println("Pacientes");
                break;

            case 2:
                System.out.println("Médicos");
                break;

            case 3:
                System.out.println("Consultas");
                break;

            case 4:
                System.out.println("Internações");
                break;

            case 5:
                System.out.println("Relatorios");
                break;

            default: 
                System.out.println("Opção inválida. Por favor, selecione novamente");
                break;
            }
        } while (opcao!=0);
        scanner.close();
    }
}