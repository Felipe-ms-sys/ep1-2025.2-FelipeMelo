package Projeto1Poo.entidades;
public class Menus{

    public static void MenuPrincipal(){

        System.out.println("-------Menu Inicial-------\n"); 
        System.out.println("Selecione a opção desejada\n"); 
        System.out.println("1. Gestão de Pacientes ");
        System.out.println("2. Gestão de Médicos ");
        System.out.println("3. Agendamento de Consultas ");
        System.out.println("4. Gestão de Internações ");
        System.out.println("5. Relatórios ");   
        System.out.println("\n0. Fechar Sistema \n");
        }
    
    
    public static void MenuPaciente(){

        System.out.println("-------Gestão de Pacientes-------\n");
        System.out.println("1. Cadastrar novo paciente ");
        System.out.println("2. Alterar dados do paciente");
        System.out.println("3. Conferir dados do paciente");
        System.out.println("4. Buscar paciente ");
        System.out.println("5. Excluir paciente ");
        System.out.println("\n0. Voltar ao Menu Principal\n ");
    }

    public static void MenuMedico(){

        System.out.println("-------Gestão de Médicos-------\n");
        System.out.println("1. Cadastrar novo médico ");
        System.out.println("2. Alterar dados do médico");
        System.out.println("3. Conferir dados do médico");
        System.out.println("4. Gerenciar agenda ");
        System.out.println("5. Buscar médico ");
        System.out.println("6. Excluir médico ");
        System.out.println("\n0. Voltar ao Menu Principal\n ");
    }

    public static void MenuConsulta(){

        System.out.println("-------Agendamento de Consultas-------\n");
        System.out.println("1. Agendar nova consulta ");
        System.out.println("2. Cancelar consulta");
        System.out.println("3. conferir agendamentos ");
        System.out.println("4. registrar diagnóstico ");
        System.out.println("5. conferir dados da consulta ");
        System.out.println("\n0. Voltar ao Menu Principal\n ");
    }

    public static void MenuInternacao(){

        System.out.println("-------Gestão de Internações-------\n");
        System.out.println("1. Registrar nova internação ");
        System.out.println("2. Cancelar internação ");
        System.out.println("3. Registrar alta de paciente ");
        System.out.println("4. Consultar internações ");
        System.out.println("5. Histórico de internações ");
        System.out.println("\n0. Voltar ao Menu Principal\n ");
    }

    public static void MenuRelatorios(){

        System.out.println("-------Relatórios-------\n");
        System.out.println("1. Relatório dos pacientes ");
        System.out.println("2. Relatório dos médicos ");
        System.out.println("3. Relatório de consultas ");
        System.out.println("4. Pacientes internados ");
        System.out.println("\n0. Voltar ao Menu Principal\n ");
    }


}
