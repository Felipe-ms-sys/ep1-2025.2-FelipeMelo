package Projeto1Poo.sistema;

import Projeto1Poo.entidades.*;
import java.util.*;
import java.time.LocalDateTime;

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
                        case 2: 
                            editarPaciente();
                            break;
                        case 3: 
                            conferirDadosPaciente();
                            break;
                        case 4: 
                            excluirPaciente();
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
                        case 1: 
                            cadastrarMedico();
                            break;
                        case 2: 
                            editarMedico();
                            break;
                        case 3: 
                           conferirDadosMedico();
                            break;
                        case 4: // Método de gerenciar agenda
                            break;
                        case 5: 
                            excluirMedico();
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
                        case 1: 
                            agendarConsulta();
                            break;
                        case 2:
                        //reagendarConsulta();
                            break;
                        case 3: 
                        //cancelarConsulta();
                            break;
                        case 4: // Método de conferir agendamentos
                            break;
                        case 5: // Método de registrar diagnóstico
                            break;
                        case 6: // Método de conferir dados da consulta
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
                        case 2: // Método de relatório das consultas
                            break;
                        case 3: // Método de pacientes internados
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

            try {
                Paciente novoPaciente = new Paciente(nome, cpf, email, idade, telefone, sexoBiologico, numeroProntuario, status, tipoSanguineo, alergias, medicamentosEmUso, convenio);

                Paciente.cadastrar(novoPaciente);
                System.out.println("Paciente cadastrado! Número do Prontuário: " + numeroProntuario + "\b");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao cadastrar paciente: " + e.getMessage());

            }
        }

        private static void editarPaciente() {
            System.out.println("-------- Editar Dados do Paciente -------");
            System.out.print("Digite o CPF do paciente: ");
            String cpf = scanner.nextLine();

            Paciente paciente = Paciente.buscarPacientePorCpf(cpf);

            if (paciente == null) {
                System.out.println("\nPaciente não encontrado.");
                return;
            }

            boolean editandoPaciente = true;
            while (editandoPaciente) {
                System.out.println("\n--- Editando Paciente: " + paciente.getNome() + " ---");
                System.out.println("1. Editar Nome");
                System.out.println("2. Editar Email");
                System.out.println("3. Editar Telefone");
                System.out.println("4. Editar Status");
                System.out.println("0. Voltar ao Menu Anterior");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("Nome atual: " + paciente.getNome());
                        System.out.print("Digite o novo nome: ");
                        String novoNome = scanner.nextLine();
                        paciente.setNome(novoNome);
                        System.out.println("Nome atualizado com sucesso!");
                        break;

                    case 2:
                        System.out.println("Email atual: " + paciente.getEmail());
                        System.out.print("Digite o novo email: ");
                        String novoEmail = scanner.nextLine();
                        paciente.setEmail(novoEmail); 
                        System.out.println("Email atualizado com sucesso!");
                        break;

                    case 3:
                        System.out.println("Telefone atual: " + paciente.getTelefone());
                        System.out.print("Digite o novo telefone: ");
                        String novoTelefone = scanner.nextLine();
                        paciente.setTelefone(novoTelefone); 
                        System.out.println("Telefone atualizado com sucesso!");
                        break;

                    case 4:
                        System.out.println("Status atual: " + paciente.getStatus());
                        System.out.print("Digite o novo status (Ativo/Inativo): ");
                        String novoStatus = scanner.nextLine();
                        paciente.setStatus(novoStatus);
                        System.out.println("Status atualizado com sucesso!");
                        break;

                    case 0:
                        editandoPaciente = false;
                        System.out.println("Retornando ao menu de pacientes...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
        }

        private static void conferirDadosPaciente() {
            System.out.println("-------- Conferir Dados do Paciente -------");
            System.out.print("Digite o CPF do paciente: ");
            String cpf = scanner.nextLine();

            Paciente paciente = Paciente.buscarPacientePorCpf(cpf);

            if (paciente == null) {
                System.out.println("\nPaciente não encontrado.");
                return;
            }

            System.out.println("\n--- Dados do Paciente ---");
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("CPF: " + paciente.getCpf());
            System.out.println("Email: " + paciente.getEmail());
            System.out.println("Telefone: " + paciente.getTelefone());
            System.out.println("Idade: " + paciente.getIdade());
            System.out.println("Sexo Biológico: " + paciente.getSexoBiologico());
            System.out.println("Número do Prontuário: " + paciente.getNumeroProntuario());
            System.out.println("Status: " + paciente.getStatus());
            System.out.println("Tipo Sanguíneo: " + paciente.getTipoSanguineo());
            if (paciente.getAlergias().isEmpty()) {
                System.out.println("Alergias: Nenhuma");
            } else {
                String alergiasFormatadas = String.join(", ", paciente.getAlergias());
                System.out.println("Alergias: " + alergiasFormatadas);
            }

            if (paciente.getMedicamentosEmUso().isEmpty()) {
                System.out.println("Medicamentos em Uso: Nenhum");
            } else {
                String medicamentosFormatados = String.join(", ", paciente.getMedicamentosEmUso());
                System.out.println("Medicamentos em Uso: " + medicamentosFormatados);
            }

            Convenio convenio = paciente.getConvenio();
            if (convenio != null) {
                System.out.println("Convênio:");
                System.out.println("  Nome do Plano: " + convenio.getNomeDoPlano());
                System.out.println("  Número do Plano: " + convenio.getNumeroDoPlano());
                System.out.println("  Tipo de Plano: " + convenio.getTipoDePlano());
            } else {
                System.out.println("Convênio: Não possui.");
            }
        }

        private static void excluirPaciente() {
            System.out.println("-------- Excluir Paciente -------");
            System.out.print("Digite o CPF do paciente a ser excluído: ");
            String cpf = scanner.nextLine();

            Paciente paciente = Paciente.buscarPacientePorCpf(cpf);

            if (paciente == null) {
                System.out.println("\nPaciente não encontrado.");
                return;
            }

            System.out.print("Tem certeza que deseja excluir o paciente " + paciente.getNome() + "? (S/N): ");
            String confirmacao = scanner.nextLine().toUpperCase();

            if (confirmacao.equalsIgnoreCase("S")) {
                Paciente.excluir(paciente);
                System.out.println("Paciente excluído com sucesso.");
            } else {
                System.out.println("Exclusão cancelada.");
            }
        }

        private static void cadastrarMedico(){
            System.out.println("-------- Cadastrar Novo Médico -------");

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

            System.out.print("Crm: ");
            String crm = scanner.nextLine();
        
            System.out.print("Especialidade (Digite o nome completo): ");
            System.out.println(Medico.listarEspecialidadesDisponiveis());
            String especialidade = scanner.nextLine();

            try {
                Medico novoMedico;          
                novoMedico = new Medico(nome, cpf, email, idade, telefone, sexoBiologico, crm, especialidade);
                
                Medico.cadastrar(novoMedico);
                System.out.println("Dr.  " + novoMedico.getNome() +"(" + novoMedico.getEspecialidade() + ") cadastrado com sucesso!\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao cadastrar médico: " + e.getMessage());
            }

        }

        private static void editarMedico() {
            System.out.println("-------- Editar Dados do Médico -------");
            System.out.print("Digite o CPF do médico: ");
            String cpf = scanner.nextLine();

            Medico medico = Medico.buscarMedicoPorCpf(cpf);

            if (medico == null) {
                System.out.println("\nMédico não encontrado.\n");
                return;
            }

            boolean editandoMedico = true;
            while (editandoMedico) {
                System.out.println("\n--- Editando Médico: " + medico.getNome() + " ---");
                System.out.println("1. Editar Nome");
                System.out.println("2. Editar Email");
                System.out.println("3. Editar Telefone");
                System.out.println("4. Editar Especialidade");
                System.out.println("5. Editar CRM");
                System.out.println("0. Voltar ao Menu Anterior");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("Nome atual: " + medico.getNome());
                        System.out.print("Digite o novo nome: ");
                        String novoNome = scanner.nextLine();
                        medico.setNome(novoNome);
                        System.out.println("Nome atualizado com sucesso!");
                        break;

                    case 2:
                        System.out.println("Email atual: " + medico.getEmail());
                        System.out.print("Digite o novo email: ");
                        String novoEmail = scanner.nextLine();
                        medico.setEmail(novoEmail); 
                        System.out.println("Email atualizado com sucesso!");
                        break;

                    case 3:
                        System.out.println("Telefone atual: " + medico.getTelefone());
                        System.out.print("Digite o novo telefone: ");
                        String novoTelefone = scanner.nextLine();
                        medico.setTelefone(novoTelefone); 
                        System.out.println("Telefone atualizado com sucesso!");
                        break;

                    case 4:
                        System.out.println("Especialidade atual: " + medico.getEspecialidade());
                        System.out.println(Medico.listarEspecialidadesDisponiveis());
                        System.out.print("Digite a nova especialidade (nome completo): ");
                        String novaEspecialidade = scanner.nextLine();
                        medico.setEspecialidade(novaEspecialidade); 
                        System.out.println("Especialidade atualizada com sucesso!");
                        break;

                    case 5:
                        System.out.println("CRM atual: " + medico.getCrm());
                        System.out.print("Digite o novo CRM: ");
                        String novoCrm = scanner.nextLine();
                        medico.setCrm(novoCrm); 
                        System.out.println("CRM atualizado com sucesso!");
                        break;

                    case 0:
                        editandoMedico = false;
                        System.out.println("Retornando ao menu de médicos");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                        
                }
            }
        }

        private static void conferirDadosMedico(){
            System.out.println("-------- Conferir Dados do Médico -------");
            System.out.print("Digite o CPF do médico: ");
            String cpf = scanner.nextLine();

            Medico medico = Medico.buscarMedicoPorCpf(cpf);

            if (medico == null) {
                System.out.println("\nMédico não encontrado.");
                return;
            }

            System.out.println("\n--- Dados do Médico ---");
            System.out.println(medico.toString());
        }
        
        private static void excluirMedico(){
            System.out.println("-------- Excluir Médico -------");
            System.out.print("Digite o CPF do médico a ser excluído: ");
            String cpf = scanner.nextLine();

            Medico medico = Medico.buscarMedicoPorCpf(cpf);

            if (medico == null) {
                System.out.println("\nMédico não encontrado.");
                return;
            }

            System.out.print("Tem certeza que deseja excluir o médico " + medico.getNome() + "? (S/N): ");
            String confirmacao = scanner.nextLine().toUpperCase();

            if (confirmacao.equalsIgnoreCase("S")) {
                Medico.excluir(medico);
                System.out.println("Médico excluído com sucesso.");
            } else {
                System.out.println("Exclusão cancelada.");
            }

        }

        private static void agendarConsulta(){
            System.out.println("-------- Agendar Nova Consulta -------");
            System.out.print("Digite o CPF do paciente: ");
            String cpfPaciente = scanner.nextLine();
            Paciente paciente = Paciente.buscarPacientePorCpf(cpfPaciente);

            if (paciente == null) {
                System.out.println("Paciente não encontrado! Tente novamente.");
                return;
            }

            System.out.print("Digite o CPF do médico: ");
            String cpfMedico = scanner.nextLine();
            Medico medico = Medico.buscarMedicoPorCpf(cpfMedico);

            if (medico == null) {
                System.out.println("Médico não encontrado! Tente novamente.");
                return;
            }

            System.out.print("Digite a data e hora da consulta (yyyy/MM/dd HH:mm): ");
            String dataHora = scanner.nextLine();
            LocalDateTime dataHoraConsulta;

            try {
                java.time.format.DateTimeFormatter formato = java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                dataHoraConsulta = LocalDateTime.parse(dataHora, formato);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Formato de data/hora inválido. Use o formato yyyy/MM/dd HH:mm.");
                return;
            }

            if (Medico.horarioOcupado(medico, dataHoraConsulta)) {
                System.out.println("O médico já possui uma consulta agendada nesse horário. Escolha outro horário.");
                return;
            }
            Consulta novaConsulta = new Consulta(paciente, medico, dataHoraConsulta);
            Consulta.adicionarConsulta(novaConsulta);
            System.out.println("Consulta agendada com sucesso para " + dataHoraConsulta + " com o Dr(a). " + medico.getNome() + ".");
        }

        // private static void cancelarConsulta(){

        // }

}
    

        
 

