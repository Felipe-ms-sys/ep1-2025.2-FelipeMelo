package Projeto1Poo.sistema;

import Projeto1Poo.entidades.*;
import java.util.*;

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
                        case 1: 
                            cadastrarPaciente();
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
                            break;
                        case 2: // Método de cancelar consulta
                            break;
                        case 3: // Método de conferir agendamentos
                            break;
                        case 4: // Método de registrar diagnóstico
                            break;
                        case 5: // Método de conferir dados da consulta
                            break;
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
                            break;
                        case 2: // Método de cancelar internação
                            break;
                        case 3: // Método de registrar alta de paciente
                            break;
                        case 4: // Método de consultar internações
                            break;
                        case 5: // Método de histórico de internações
                            break;
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
                            break;
                        case 2: // Método de relatório dos médicos
                            break;
                        case 3: // Método de relatório das consultas
                            break;
                        case 4: // Método de pacientes internados
                            break;
                    }       
                    break;

                default: 
                    System.out.println("Opção inválida. Por favor, selecione novamente");
                    break;
            }
        }

        }

        private static void cadastrarPaciente(){
            String status = "Ativo";
            String numeroProntuario = "P" + (Paciente.listarTodos().size() + 1);

            System.out.println("-------- Cadastrar Novo Paciente -------");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Sexo Biológico (M/F): ");
            String sexoBiologico = scanner.nextLine().toUpperCase();

            System.out.print("Tipo Sanguíneo: ");
            String tipoSanguineo = scanner.nextLine();

            List<String> alergias = new ArrayList<>();
            System.out.print("O paciente possui alergias? (S/N): ");
            String respostaAlergia = scanner.nextLine().toUpperCase();

            if (respostaAlergia.equalsIgnoreCase("S")) {
                System.out.print("Digite as alergias (separadas por vírgula): ");
                String alergiasPaciente = scanner.nextLine();
                
                if (alergiasPaciente != null && !alergiasPaciente.trim().isEmpty()) {
                    
                    String[] alergiasArray = alergiasPaciente.split(",");
                    for (String alergia : alergiasArray) {
                        alergias.add(alergia.trim());
                    }
                }
            }

            List<String> medicamentosEmUso = new ArrayList<>();
            System.out.print("O paciente utiliza algum medicamento? (S/N): ");
            String respostaMedicamento = scanner.nextLine().toUpperCase();

            if (respostaMedicamento.equalsIgnoreCase("S")) {
                System.out.print("Digite os medicamentos (separados por vírgula): ");
                String medicamentoEmUsoPaciente = scanner.nextLine();
                
                if (medicamentoEmUsoPaciente != null && !medicamentoEmUsoPaciente.trim().isEmpty()) {
                    
                    String[] medicamentosEmUsoArray = medicamentoEmUsoPaciente.split(",");
                    for (String medicamentos : medicamentosEmUsoArray) {
                        medicamentosEmUso.add(medicamentos.trim());
                    }
                }
            }

            Convenio convenio = null;
            System.out.print("Paciente tem plano de saúde? (S/N): ");
            String respostaConvenio = scanner.nextLine().toUpperCase();

            if (respostaConvenio.equalsIgnoreCase("S")){
                System.out.print("Nome do Plano: ");
                String nomeDoPlano = scanner.nextLine();

                System.out.print("Número do Plano: ");
                String numeroDoPlano = scanner.nextLine();

                System.out.print("Tipo de Plano: ");
                String tipoDePlano = scanner.nextLine();

                convenio = new Convenio(nomeDoPlano, numeroDoPlano, tipoDePlano);
            }     
            
            
            System.out.print("Nome do Contato de Emergência: ");
            String nomeContatoEmergencia = scanner.nextLine();

            System.out.print("Número do Contato de Emergência: ");
            String numeroContatoEmergencia = scanner.nextLine();

            System.out.print("Parentesco com o Contato de Emergência: ");
            String parentescoContatoDeEmergencia = scanner.nextLine();

            try {
                Paciente novoPaciente = new Paciente(nome, cpf, email, idade, telefone, sexoBiologico, numeroProntuario, status, tipoSanguineo, alergias, medicamentosEmUso, nomeContatoEmergencia, numeroContatoEmergencia, parentescoContatoDeEmergencia, convenio);

                Paciente.cadastrar(novoPaciente);
                System.out.println("Paciente cadastrado! Número do Prontuário: " + numeroProntuario + "\b");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao cadastrar paciente: " + e.getMessage());

            }
        }
    }
    
    

