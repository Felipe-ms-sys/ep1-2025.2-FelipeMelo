package Projeto1Poo.sistema;
import Projeto1Poo.entidades.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Persistencia {
    private static final String DIRETORIO = "Projeto1Poo/dados/";
    private static final String ARQUIVO_PACIENTES = DIRETORIO + "pacientes.txt";
    private static final String ARQUIVO_MEDICOS = DIRETORIO + "medicos.txt";
    private static final String ARQUIVO_LOCAIS = DIRETORIO + "locais.txt";
    private static final String ARQUIVO_CONSULTAS = DIRETORIO + "consultas.txt";
    private static final String ARQUIVO_INTERNACOES = DIRETORIO + "internacoes.txt";
    
    public static void carregarTodosDados() {
        new File(DIRETORIO).mkdirs();
        carregarLocais();
        carregarPacientes();
        carregarMedicos();
        carregarConsultas();
        carregarInternacoes();
    }


    public static void carregarPacientes() {
        if (!new File(ARQUIVO_PACIENTES).exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_PACIENTES))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";", -1); 
                if (dados.length >= 12) {
                    String cpf = dados[0];
                    String nome = dados[1];
                    String email = dados[2];
                    int idade = Integer.parseInt(dados[3]);
                    String telefone = dados[4];
                    String sexo = dados[5];
                    String prontuario = dados[6];
                    String status = dados[7];
                    String tipoSanguineo = dados[8];

                    List<String> alergias = new ArrayList<>();
                    if (!dados[9].isEmpty()) {
                        alergias.addAll(Arrays.asList(dados[9].split(",")));
                    }

                    List<String> medicamentos = new ArrayList<>();
                    if (!dados[10].isEmpty()) {
                        medicamentos.addAll(Arrays.asList(dados[10].split(",")));
                    }

                    Convenio convenio = null;
                    if (!dados[11].isEmpty()) {
                        String[] convDados = dados[11].split("\\|");
                        if (convDados.length == 3) {
                            convenio = new Convenio(convDados[0], convDados[1], convDados[2]);
                        }
                    }

                    if (Paciente.buscarPacientePorCpf(cpf) == null) {
                        Paciente paciente = new Paciente(nome, cpf, email, idade, telefone, sexo, prontuario, status, tipoSanguineo, alergias, medicamentos, convenio);
                        Paciente.cadastrar(paciente);
                    }
                }
            }
        } catch (Exception e) { 
            System.err.println("Erro ao carregar pacientes: " + e.getMessage());
        }
    }

    public static void carregarMedicos(){
        if (!new File(ARQUIVO_MEDICOS).exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_MEDICOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";", -1); 
                if (dados.length >= 8) {
                    String cpf = dados[0];
                    String nome = dados[1];
                    String email = dados[2];
                    int idade = Integer.parseInt(dados[3]);
                    String telefone = dados[4];
                    String sexo = dados[5];
                    String crm = dados[6];
                    Especialidade especialidade = Especialidade.fromString(dados[7]);

                    if (Medico.buscarMedicoPorCpf(cpf) == null) {
                            Medico medico = new Medico(nome, cpf, email, idade, telefone, sexo, crm, especialidade);
                            Medico.cadastrar(medico);
                    }
                }
            }
        } catch(Exception e){
            System.err.println("Erro ao carregar médicos" + e.getMessage());
        }
    }

    public static void carregarLocais() {
        if (!new File(ARQUIVO_LOCAIS).exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_LOCAIS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (Local.buscarPorNome(linha) == null) {
                    Local.adicionarLocal(new Local(linha));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar locais: " + e.getMessage());
        }
    }

    public static void carregarConsultas() {
        if (!new File(ARQUIVO_CONSULTAS).exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_CONSULTAS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";", -1);

                if (dados.length >= 7) { 
                    String cpfPaciente = dados[0];
                    String cpfMedico = dados[1];
                    String nomeLocal = dados[2]; 

                    Paciente paciente = Paciente.buscarPacientePorCpf(cpfPaciente);
                    Medico medico = Medico.buscarMedicoPorCpf(cpfMedico);
                    Local local = Local.buscarPorNome(nomeLocal); 

                    if (paciente != null && medico != null && local != null) {
                        LocalDateTime dataHora = LocalDateTime.parse(dados[3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

                        Consulta consulta = new Consulta(paciente, medico, dataHora, local);

                        consulta.setStatus(dados[4]);
                        if (!dados[5].isEmpty()) {
                            consulta.setDiagnostico(dados[5]);
                        }
                        if (!dados[6].isEmpty()) {
                            consulta.setPrescricao(dados[6]);
                        }

                        Consulta.adicionarConsulta(consulta);
                    } else {
                        System.err.println("Não foi possível carregar consulta: Paciente, Médico ou Local não encontrado");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar consultas: " + e.getMessage());
        }
    }

    public static void carregarInternacoes() {
        if (!new File(ARQUIVO_INTERNACOES).exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_INTERNACOES))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";", -1);

                if (dados.length >= 6) {
                    String cpfPaciente = dados[0];
                    String cpfMedico = dados[1];
                    String nomeLeito = dados[2];

                    Paciente paciente = Paciente.buscarPacientePorCpf(cpfPaciente);
                    Medico medico = Medico.buscarMedicoPorCpf(cpfMedico);
                    Leito leito = Leito.buscarPorNome(nomeLeito);

                    if (paciente != null && medico != null && leito != null) {
                        String dataInternacao = dados[3];

                        Internacao internacao = new Internacao(paciente, medico, dataInternacao, leito);

                        String dataAlta = dados[4];
                        if (!dataAlta.isEmpty()) {
                            internacao.setDataAlta(dataAlta);
                        }
                        internacao.setStatus(dados[5]);

                        if (internacao.getStatus().equalsIgnoreCase("Ativa")) {
                            leito.setDisponibilidade(false);
                            paciente.setStatus("Internado");
                        }

                        Internacao.adicionarInternacao(internacao);

                    } else {
                        System.err.println("Não foi possível carregar internação: Paciente, Médico ou Leito não encontrado");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar internações: " + e.getMessage());
        }
    }

    public static void salvarTodosDados() {
        salvarPacientes(Paciente.listarTodos());
        salvarMedicos(Medico.listarTodos());
        salvarLocais(Local.listarTodos());  
        salvarConsultas(Consulta.listarTodas());
        salvarInternacoes(Internacao.listarTodas());
    }

    public static void salvarPacientes(List<Paciente> pacientes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_PACIENTES))) {
            for (Paciente paciente : pacientes) {
                
                String alergiasStr = String.join(",", paciente.getAlergias());
                String medicamentosStr = String.join(",", paciente.getMedicamentosEmUso());

                String convenioStr = "";
                if (paciente.getConvenio() != null) {
                    Convenio c = paciente.getConvenio();
                    convenioStr = String.join("/", c.getNomeDoPlano(), c.getNumeroDoPlano(), c.getTipoDePlano());
                }

                String linha = String.join(";",
                        paciente.getCpf(),
                        paciente.getNome(),
                        paciente.getEmail(),
                        String.valueOf(paciente.getIdade()),
                        paciente.getTelefone(),
                        paciente.getSexoBiologico(),
                        paciente.getNumeroProntuario(),
                        paciente.getStatus(),
                        paciente.getTipoSanguineo(),
                        alergiasStr,
                        medicamentosStr,
                        convenioStr
                );
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar pacientes: " + e.getMessage());
        }
    }

    public static void salvarMedicos(List<Medico> medicos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_MEDICOS))) {
            for (Medico medico : medicos) {

                String linha = String.join(";",
                        medico.getCpf(),
                        medico.getNome(),
                        medico.getEmail(),
                        String.valueOf(medico.getIdade()),
                        medico.getTelefone(),
                        medico.getSexoBiologico(),
                        medico.getCrm(),
                        medico.getEspecialidade().getNome() 
                );
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar médicos: " + e.getMessage());
        }
    }

    public static void salvarLocais(List<Local> locais) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_LOCAIS))) {
            for (Local local : locais) {
                writer.write(local.getNome());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar locais: " + e.getMessage());
        }
    }
    
    public static void salvarConsultas(List<Consulta> consultas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_CONSULTAS))) {
            for (Consulta consulta : consultas) {
    
                String linha = String.join(";",
                        consulta.getPaciente().getCpf(),
                        consulta.getMedico().getCpf(),
                        consulta.getDataHoraConsulta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                        consulta.getStatus(),
                        consulta.getDiagnostico() != null ? consulta.getDiagnostico() : "",
                        consulta.getPrescricao() != null ? consulta.getPrescricao() : ""
                );
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar consultas: " + e.getMessage());
        }
    }

    public static void salvarInternacoes(List<Internacao> internacoes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_INTERNACOES))) {
            for (Internacao internacao : internacoes) {
                
                String dataAltaStr = internacao.getDataAlta() != null ? internacao.getDataAlta() : "";

                String linha = String.join(";",
                        internacao.getPaciente().getCpf(),
                        internacao.getMedicoResponsavel().getCpf(),
                        internacao.getLeito().getNome(),
                        internacao.getDataInternacao(),
                        dataAltaStr, 
                        internacao.getStatus()
                );
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar internações: " + e.getMessage());
        }
    }

}


    
