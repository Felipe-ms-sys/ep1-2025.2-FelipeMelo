package Projeto1Poo.sistema;
import Projeto1Poo.entidades.*;
import java.util.Scanner;

public class Main{
    
    private static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args){

        boolean executando = true;
        EstadoMenu estadoAtual = EstadoMenu.PRINCIPAL;
        while (executando){

            switch (estadoAtual) {    
                case SAIR:
                    System.out.println("Fechando Sistema");
                    executando = false;
                    break; 

                case PRINCIPAL:
                    Menus.MenuPrincipal();
                    int opcaoPrincipal = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoPrincipal) {
                        case 0:
                            estadoAtual = EstadoMenu.SAIR;
                            break;
                        case 1:
                            estadoAtual = EstadoMenu.PACIENTE;
                            break;
                        case 2:
                            estadoAtual = EstadoMenu.MEDICO;
                            break;
                        case 3:
                            estadoAtual = EstadoMenu.CONSULTA;
                            break;
                        case 4:
                            estadoAtual = EstadoMenu.INTERNACAO;
                            break;
                        case 5:
                            estadoAtual = EstadoMenu.RELATORIOS;
                            break;    
                        default:
                            System.out.println("Opção inválida. Por favor, selecione novamente");
                            break;
                    }
                    break;  

                case PACIENTE:
                    Menus.MenuPaciente();
                    int opcaoPaciente = scanner.nextInt();
                    scanner.nextLine();

                    switch(opcaoPaciente){

                        case 0:
                            estadoAtual = EstadoMenu.PRINCIPAL;
                            break;
                        case 1: // Método de  cadastrar paciente
                            break;
                        case 2: // Método de alterar dados do paciente
                            break;
                        case 3: // Método de conferir dados do paciente
                            break;
                        case 4: // Método de buscar paciente
                            break;
                        case 5: // Método de excluir paciente
                            break;
                        
                    }
                    break;


                case MEDICO:
                    Menus.MenuMedico();
                    int opcaoMedico = scanner.nextInt();
                    scanner.nextLine();

                    switch(opcaoMedico){

                        case 0:
                            estadoAtual = EstadoMenu.PRINCIPAL;
                            break;
                        case 1: // Método de cadastrar médico
                            break;
                        case 2: // Método de alterar dados do médico
                            break;
                        case 3: // Método de conferir dados do médico
                            break;
                        case 4: // Método de gerenciar agenda
                            break;
                        case 5: // Método de buscar médico
                            break;
                        case 6: // Método de excluir médico
                            break;
                    }
                    break;

                case CONSULTA:
                    Menus.MenuConsulta();
                    int opcaoConsulta = scanner.nextInt();
                    scanner.nextLine();
                    switch(opcaoConsulta){

                        case 0:
                            estadoAtual = EstadoMenu.PRINCIPAL;
                            break;
                        case 1: // Método de agendar nova consulta
                        case 2: // Método de cancelar consulta
                        case 3: // Método de conferir agendamentos
                        case 4: // Método de registrar diagnóstico
                        case 5: // Método de conferir dados da consulta
                    }
                    break;

                case INTERNACAO:
                    Menus.MenuInternacao();
                    int opcaoInternacao = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcaoInternacao){

                        case 0:
                            estadoAtual = EstadoMenu.PRINCIPAL;
                            break;
                        case 1: // Método de registrar nova internação
                        case 2: // Método de cancelar internação
                        case 3: // Método de registrar alta de paciente
                        case 4: // Método de consultar internações
                        case 5: // Método de histórico de internações
                    }
                    break;

                case RELATORIOS:
                    Menus.MenuRelatorios();
                    int opcaoRelatorios = scanner.nextInt();
                    scanner.nextLine();
                    switch(opcaoRelatorios){

                        case 0:
                            estadoAtual = EstadoMenu.PRINCIPAL;
                            break;
                        case 1: // Método de relatório dos pacientes
                        case 2: // Método de relatório dos médicos
                        case 3: // Método de relatório das consultas
                        case 4: // Método de pacientes internados
                    }
                    break;

                default: 
                    System.out.println("Opção inválida. Por favor, selecione novamente");
                    break;
            }
        }
    }
}