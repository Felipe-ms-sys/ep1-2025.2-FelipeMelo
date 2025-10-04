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
                            reagendarConsulta();
                            break;
                        case 3: 
                            cancelarConsulta();
                            break;
                        case 4: 
                            registrarDiagnostico();
                            break;
                        case 5: 
                            conferirConsultas(); //Histórico de consultas do paciente
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
                        case 1: 
                            //registrarInternacao();
                            break;
                        case 2: 
                            //cancelarInternacao();
                            break;
                        case 3:
                            //registrarAlta();
                            break;
                        case 4: 
                            //consultarInternacoes();
                            break;
                        case 5: 
                            //conferirInternacoes(); //Histórico de internações do paciente
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
            System.out.println("\nPaciente cadastrado! Número do Prontuário: " + numeroProntuario + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro ao cadastrar paciente: " + e.getMessage());

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
            System.out.println("2. Editar CPF");
            System.out.println("3. Editar Idade");
            System.out.println("4. Editar Email");
            System.out.println("5. Editar Telefone");
            System.out.println("6. Editar Sexo biológico");
            System.out.println("7. Editar tipo sanguíneo");
            System.out.println("8. Editar alergias");
            System.out.println("9. Editar medicamentos em uso");
            System.out.println("10. Editar convênio");
            System.out.println("11. Editar Status");
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
                    System.out.println("CPF atual: " + paciente.getCpf());
                    System.out.print("Digite o novo CPF: ");
                    String novoCpf = scanner.nextLine();
                    if (Paciente.buscarPacientePorCpf(novoCpf) != null) {
                        System.out.println("Erro: CPF já cadastrado para outro paciente.");
                    } else {
                        paciente.setCpf(novoCpf);
                        System.out.println("CPF atualizado com sucesso!");
                    }
                    break;

                case 3:
                    System.out.println("Idade atual: " + paciente.getIdade());
                    System.out.print("Digite a nova idade: ");
                    int novaIdade = scanner.nextInt();
                    scanner.nextLine(); 
                    paciente.setIdade(novaIdade);
                    System.out.println("Idade atualizada com sucesso!");
                    break;

                case 4:
                    System.out.println("Email atual: " + paciente.getEmail());
                    System.out.print("Digite o novo email: ");
                    String novoEmail = scanner.nextLine();
                    paciente.setEmail(novoEmail); 
                    System.out.println("Email atualizado com sucesso!");
                    break;

                case 5:
                    System.out.println("Telefone atual: " + paciente.getTelefone());
                    System.out.print("Digite o novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    paciente.setTelefone(novoTelefone); 
                    System.out.println("Telefone atualizado com sucesso!");
                    break;

                case 6:
                    System.out.println("Sexo Biológico atual: " + paciente.getSexoBiologico());
                    System.out.print("Digite o novo Sexo Biológico (M/F): ");
                    String novoSexoBiologico = scanner.nextLine().toUpperCase();
                    paciente.setSexoBiologico(novoSexoBiologico); 
                    System.out.println("Sexo Biológico atualizado com sucesso!");
                    break;

                case 7:
                    System.out.println("Tipo Sanguíneo atual: " + paciente.getTipoSanguineo());
                    System.out.print("Digite o novo tipo sanguíneo: ");
                    String novoTipoSanguineo = scanner.nextLine();
                    paciente.setTipoSanguineo(novoTipoSanguineo);
                    System.out.println("Tipo sanguíneo atualizado com sucesso!");
                    break;

                case 8:
                    System.out.println("Alergias atuais: " + paciente.getAlergias());
                    List<String> novasAlergias = new ArrayList<>();
                    System.out.print("O paciente possui alergias? (S/N): ");
                    String respostaAlergia = scanner.nextLine().toUpperCase();

                    if (respostaAlergia.equalsIgnoreCase("S")) {
                        System.out.print("Digite as alergias (separadas por vírgula): ");
                        String alergiasPaciente = scanner.nextLine();
                        
                        if (alergiasPaciente != null && !alergiasPaciente.trim().isEmpty()) {
                            
                            String[] alergiasArray = alergiasPaciente.split(",");
                            for (String alergia : alergiasArray) {
                                novasAlergias.add(alergia.trim());
                            }
                        }
                    }
                    paciente.setAlergias(novasAlergias);
                    System.out.println("Alergias atualizadas com sucesso!");
                    break;

                case 9:
                    System.out.println("Medicamentos em uso atuais: " + paciente.getMedicamentosEmUso());
                    List<String> novosMedicamentosEmUso = new ArrayList<>();
                    System.out.print("O paciente utiliza algum medicamento? (S/N): ");
                    String respostaMedicamento = scanner.nextLine().toUpperCase();

                    if (respostaMedicamento.equalsIgnoreCase("S")) {
                        System.out.print("Digite os medicamentos (separados por vírgula): ");
                        String medicamentoEmUsoPaciente = scanner.nextLine();
                        
                        if (medicamentoEmUsoPaciente != null && !medicamentoEmUsoPaciente.trim().isEmpty()) {
                            
                            String[] medicamentosEmUsoArray = medicamentoEmUsoPaciente.split(",");
                            for (String medicamentos : medicamentosEmUsoArray) {
                                novosMedicamentosEmUso.add(medicamentos.trim());
                            }
                        }
                    }
                    paciente.setMedicamentosEmUso(novosMedicamentosEmUso);
                    System.out.println("Medicamentos em uso atualizados com sucesso!");
                    break;

                case 10:
                    Convenio convenioAtual = paciente.getConvenio();
                    if (convenioAtual != null) {
                        System.out.println("Convênio atual: " + convenioAtual);
                    } else {
                        System.out.println("O paciente não possui convênio.");
                    }

                    System.out.print("O paciente tem plano de saúde? (S/N): ");
                    String respostaConvenio = scanner.nextLine().toUpperCase();

                    if (respostaConvenio.equalsIgnoreCase("S")){
                        System.out.print("Nome do Plano: ");
                        String nomeDoPlano = scanner.nextLine();

                        System.out.print("Número do Plano: ");
                        String numeroDoPlano = scanner.nextLine();

                        System.out.print("Tipo de Plano: ");
                        String tipoDePlano = scanner.nextLine();

                        Convenio novoConvenio = new Convenio(nomeDoPlano, numeroDoPlano, tipoDePlano);
                        paciente.setConvenio(novoConvenio);
                        System.out.println("Convênio atualizado com sucesso!");
                    } else {
                        paciente.setConvenio(null);
                        System.out.println("Convênio removido com sucesso!");
                    }
                    break;

                case 11:
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
        System.out.println(paciente.toString());
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
        } 
        else {
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
            System.out.println("Dr. " + novoMedico.getNome() +" (" + novoMedico.getEspecialidade() + ") cadastrado com sucesso!\n");
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
            System.out.println("2. Editar CPF");
            System.out.println("3. Editar Idade");
            System.out.println("4. Editar Email");
            System.out.println("5. Editar Telefone");
            System.out.println("6. Editar Sexo Biológico");
            System.out.println("7. Editar Especialidade");
            System.out.println("8. Editar CRM");
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
                    System.out.println("CPF atual: " + medico.getCpf());
                    System.out.print("Digite o novo CPF: ");
                    String novoCpf = scanner.nextLine();
                    if (Medico.buscarMedicoPorCpf(novoCpf) != null) {
                        System.out.println("Erro: CPF já cadastrado para outro médico.");
                    } else {
                        medico.setCpf(novoCpf);
                        System.out.println("CPF atualizado com sucesso!");
                    }
                    break;

                case 3:
                    System.out.println("Idade atual: " + medico.getIdade());
                    System.out.print("Digite a nova idade: ");
                    int novaIdade = scanner.nextInt();
                    scanner.nextLine(); 
                    medico.setIdade(novaIdade);
                    System.out.println("Idade atualizada com sucesso!");
                    break;

                case 4:
                    System.out.println("Email atual: " + medico.getEmail());
                    System.out.print("Digite o novo email: ");
                    String novoEmail = scanner.nextLine();
                    medico.setEmail(novoEmail); 
                    System.out.println("Email atualizado com sucesso!");
                    break;

                case 5:
                    System.out.println("Telefone atual: " + medico.getTelefone());
                    System.out.print("Digite o novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    medico.setTelefone(novoTelefone); 
                    System.out.println("Telefone atualizado com sucesso!");
                    break;

                case 6:
                    System.out.println("Sexo Biológico atual: " + medico.getSexoBiologico());
                    System.out.print("Digite o novo Sexo Biológico (M/F): ");
                    String novoSexoBiologico = scanner.nextLine().toUpperCase();
                    medico.setSexoBiologico(novoSexoBiologico); 
                    System.out.println("Sexo Biológico atualizado com sucesso!");
                    break;

                case 7:
                    System.out.println("Especialidade atual: " + medico.getEspecialidade());
                    System.out.println(Medico.listarEspecialidadesDisponiveis());
                    System.out.print("Digite a nova especialidade (nome completo): ");
                    String novaEspecialidade = scanner.nextLine();
                    medico.setEspecialidade(novaEspecialidade); 
                    System.out.println("Especialidade atualizada com sucesso!");
                    break;

                case 8:
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
        } 
        else {
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

        System.out.print("Digite a data e hora da consulta (dd/MM/yyyy HH:mm): ");
        String dataHora = scanner.nextLine();
        LocalDateTime dataHoraConsulta;

        try {
            java.time.format.DateTimeFormatter formato = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            dataHoraConsulta = LocalDateTime.parse(dataHora, formato);
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Formato de data/hora inválido. Use o formato dd/MM/yyyy HH:mm.");
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
    
    private static void reagendarConsulta(){
        java.time.format.DateTimeFormatter formato = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
        System.out.println("-------- Reagendar Consulta -------");
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();
        Paciente paciente = Paciente.buscarPacientePorCpf(cpfPaciente);

        if (paciente == null) {
            System.out.println("Paciente não encontrado! Tente novamente.");
            return;
        }

            List<Consulta> consultasDoPaciente = new ArrayList<>();
        for (Consulta con : Consulta.listarTodas()) {
            if (con.getPaciente().equals(paciente)) {
                consultasDoPaciente.add(con);
            }   
        }

        if (consultasDoPaciente.isEmpty()) {
        System.out.println("Nenhuma consulta encontrada para este paciente.");
        return;
        }
        
        System.out.println("\n--- Consultas Agendadas para " + paciente.getNome() + " ---");
        
        for (int i = 0; i < consultasDoPaciente.size(); i++) { //Cria uma lista numerada dinâmica
            Consulta consultaAtual = consultasDoPaciente.get(i);
            System.out.println((i + 1) + ". " +
                    "Dr(a): " + consultaAtual.getMedico().getNome() +
                    " - Data: " + consultaAtual.getDataHoraConsulta().format(formato));
        }
        System.out.println("0. Voltar");

        System.out.print("\nSelecione a opção da consulta que deseja reagendar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 0) {
        System.out.println("Operação cancelada.");
        return;
        }
        else if (opcao >= 1 && opcao <= consultasDoPaciente.size()) {
            Consulta consultaAntiga = consultasDoPaciente.get(opcao - 1);
            System.out.print("Digite a NOVA data e hora da consulta (dd/MM/yyyy HH:mm): ");
            String novaDataHoraReagendamento = scanner.nextLine();
            LocalDateTime novaDataHora;

            try {
                novaDataHora = LocalDateTime.parse(novaDataHoraReagendamento, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Formato de data/hora inválido. Use o formato dd/MM/yyyy HH:mm.");
                return;
            }

            if (Medico.horarioOcupado(consultaAntiga.getMedico(), novaDataHora)) {
                System.out.println("O médico já possui uma consulta agendada nesse novo horário. Escolha outro momento.");
                return;
            }

            Consulta.removerConsulta(consultaAntiga);
            Consulta novaConsulta = new Consulta(consultaAntiga.getPaciente(), consultaAntiga.getMedico(), novaDataHora);
                
            Consulta.adicionarConsulta(novaConsulta);
            System.out.println("Consulta reagendada com sucesso para " + novaDataHora.format(formato) + "!");
        } 
        else {
            System.out.println("Opção inválida.");
        }
    }
        
    private static void cancelarConsulta(){
        java.time.format.DateTimeFormatter formato = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
        System.out.println("-------- Cancelar Consulta -------");
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();
        Paciente paciente = Paciente.buscarPacientePorCpf(cpfPaciente);

        if (paciente == null) {
            System.out.println("Paciente não encontrado! Tente novamente.");
            return;
        }

        List<Consulta> consultasDoPaciente = new ArrayList<>();
        for (Consulta con : Consulta.listarTodas()) {
            if (con.getPaciente().equals(paciente)) {
                consultasDoPaciente.add(con);
            }   
        }

        if (consultasDoPaciente.isEmpty()) {
        System.out.println("Nenhuma consulta encontrada para este paciente.");
        return;
        }
        
        System.out.println("\n--- Consultas Agendadas para " + paciente.getNome() + " ---");
        
        for (int i = 0; i < consultasDoPaciente.size(); i++) { 
            Consulta consultaAtual = consultasDoPaciente.get(i);
            System.out.println((i + 1) + ". " +
                    "Dr(a): " + consultaAtual.getMedico().getNome() +
                    " - Data: " + consultaAtual.getDataHoraConsulta().format(formato));
        }
        System.out.println("0. Voltar");

        System.out.print("\nSelecione a opção da consulta que deseja cancelar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 0) {
            System.out.println("Operação cancelada.");
        } 
        else if (opcao >= 1 && opcao <= consultasDoPaciente.size()) {
            Consulta consultaParaCancelar = consultasDoPaciente.get(opcao - 1);
            Consulta.removerConsulta(consultaParaCancelar); 
            System.out.println("Consulta cancelada com sucesso!");
        } 
        else {
            System.out.println("Opção inválida.");
        }  
    }

    private static void registrarDiagnostico() {
        System.out.println("-------- Registrar Diagnóstico -------");
        System.out.print("Digite o CPF do paciente para ver suas consultas: ");
        String cpfPaciente = scanner.nextLine();
        Paciente paciente = Paciente.buscarPacientePorCpf(cpfPaciente);

        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }

        List<Consulta> consultasAgendadas = new ArrayList<>();
        for (Consulta c : Consulta.listarTodas()) {
            if (c.getPaciente().equals(paciente) && c.getStatus().equalsIgnoreCase("Agendada")) {
                consultasAgendadas.add(c);
            }
        }

        if (consultasAgendadas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada encontrada para este paciente.");
            return;
        }

        System.out.println("\n--- Consultas Agendadas para " + paciente.getNome() + " ---");
        java.time.format.DateTimeFormatter formato = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
        for (int i = 0; i < consultasAgendadas.size(); i++) {
            Consulta consultaAtual = consultasAgendadas.get(i);
            System.out.println((i + 1) + ". " +
                    "Dr(a): " + consultaAtual.getMedico().getNome() +
                    " - Data: " + consultaAtual.getDataHoraConsulta().format(formato));
        }
        System.out.println("0. Voltar");

        System.out.print("\nSelecione a consulta para registrar o diagnóstico: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 0) {
            System.out.println("Operação cancelada.");
            return;
        }
        else if (opcao >= 1 && opcao <= consultasAgendadas.size()) {
            Consulta consultaDiagnostico = consultasAgendadas.get(opcao - 1);

            System.out.print("Digite o diagnóstico: ");
            String diagnostico = scanner.nextLine();

            System.out.print("Digite a prescrição de medicamentos: ");
            String prescricao = scanner.nextLine();

            consultaDiagnostico.setDiagnostico(diagnostico);
            consultaDiagnostico.setPrescricao(prescricao);
            consultaDiagnostico.setStatus("Realizada"); 

            System.out.println("Diagnóstico e prescrição registrados com sucesso!");

            System.out.print("\nÉ necessário registrar uma internação para este paciente? (S/N): ");
            String respostaInternacao = scanner.nextLine().toUpperCase();

            if (respostaInternacao.equalsIgnoreCase("S")) {
        
                System.out.println("Redirecionando para o registro de internação...");
                // registrarInternacao(paciente);
            } 
            else {
                System.out.println("Consulta finalizada.");
            }    
        } 
        else {
                System.out.println("Opção inválida.");
            return;
        }
    }

    private static void conferirConsultas(){
        System.out.println("-------- Conferir Consultas do Paciente -------");
        System.out.print("Digite o CPF do paciente para ver suas consultas: ");
        String cpfPaciente = scanner.nextLine();
        Paciente paciente = Paciente.buscarPacientePorCpf(cpfPaciente);

        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }

        List<Consulta> consultasDoPaciente = new ArrayList<>();
        for (Consulta c : Consulta.listarTodas()) {
            if (c.getPaciente().equals(paciente) && (c.getStatus().equalsIgnoreCase("Agendada") || c.getStatus().equalsIgnoreCase("Realizada"))) {
                consultasDoPaciente.add(c);
            }
        }

        if (consultasDoPaciente.isEmpty()) {
            System.out.println("Nenhuma consulta (agendada ou realizada) encontrada para este paciente.");
            return;
        }

        System.out.println("\n--- Consultas de " + paciente.getNome() + " ---");
        java.time.format.DateTimeFormatter formato = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
        for (int i = 0; i < consultasDoPaciente.size(); i++) {
            Consulta consultaAtual = consultasDoPaciente.get(i);
            System.out.println((i + 1) + ". " +
                    "Dr(a): " + consultaAtual.getMedico().getNome() +
                    " - Data: " + consultaAtual.getDataHoraConsulta().format(formato) + 
                    " - Status: " + consultaAtual.getStatus()); 
        }
        System.out.println("0. Voltar");

        System.out.print("\nSelecione a consulta para ver os detalhes: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 0) {
            System.out.println("Operação cancelada.");
            return;
        }
        else if (opcao >= 1 && opcao <= consultasDoPaciente.size()) {
            Consulta consultaConferencia = consultasDoPaciente.get(opcao - 1);

            System.out.println("\n--- Detalhes da Consulta ---");
            System.out.println(consultaConferencia.toString());
        } 
        else {
            System.out.println("Opção inválida.");
        }
    }
}
        
    

        
 

