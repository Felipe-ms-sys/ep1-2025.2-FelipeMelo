package Projeto1Poo.entidades;
import java.util.List;
import java.util.ArrayList;

public class Paciente extends Pessoa {
    private static List<Paciente> todosPacientes = new ArrayList<>();

    private String numeroProntuario;
    private String status;
    private String tipoSanguineo;
    private List<String> alergias;
    private List<String> medicamentosEmUso;

    private String nomeContatoEmergencia;
    private String numeroContatoEmergencia;
    private String parentescoContatoDeEmergencia;
    private Convenio convenio;

    public Paciente(String nome, String cpf, String email, int idade, String telefone, String sexoBiologico, String numeroProntuario, String status, String tipoSanguineo, List<String> alergias, List<String> medicamentosEmUso, String nomeContatoEmergencia, String numeroContatoEmergencia, String parentescoContatoDeEmergencia, Convenio convenio) {

        super(nome, cpf, email, idade, telefone, sexoBiologico);
        this.numeroProntuario = numeroProntuario;
        this.status = status;
        this.tipoSanguineo = tipoSanguineo;
        this.alergias = alergias;
        this.medicamentosEmUso = medicamentosEmUso;
        this.nomeContatoEmergencia = nomeContatoEmergencia;
        this.numeroContatoEmergencia = numeroContatoEmergencia;
        this.parentescoContatoDeEmergencia = parentescoContatoDeEmergencia;
        this.convenio = convenio;
    }

    public static void cadastrar(Paciente paciente) {
        for (Paciente a : todosPacientes) {
            if (a.getCpf().equals(paciente.getCpf())) {
                throw new IllegalArgumentException("Cpf já cadastrado!");
            }
        }
        todosPacientes.add(paciente);
    }

    public static List<Paciente> listarTodos() {
        return new ArrayList<>(todosPacientes);
    }

    public static Paciente buscarPacientePorCpf(String cpf){
        for(Paciente paciente : todosPacientes){
            if (paciente.getCpf().equals(cpf))
            return paciente;
            }
        return null;
    }

    public static void excluir(Paciente paciente) {
        todosPacientes.remove(paciente);
    }

    public String getNumeroProntuario() {
        return numeroProntuario;
    }

    public void setNumeroProntuario(String numeroProntuario) {
        this.numeroProntuario = numeroProntuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public List<String> getMedicamentosEmUso() {
        return medicamentosEmUso;
    }

    public void setMedicamentosEmUso(List<String> medicamentosEmUso) {
        this.medicamentosEmUso = medicamentosEmUso;
    }

    public String getNomeContatoEmergencia() {
        return nomeContatoEmergencia;
    }

    public void setNomeContatoEmergencia(String nomeContatoEmergencia) {
        this.nomeContatoEmergencia = nomeContatoEmergencia;
    }

    public String getNumeroContatoEmergencia() {
        return numeroContatoEmergencia;
    }

    public void setNumeroContatoEmergencia(String numeroContatoEmergencia) {
        this.numeroContatoEmergencia = numeroContatoEmergencia;
    }

    public String getParentescoContatoDeEmergencia() {
        return parentescoContatoDeEmergencia;
    }

    public void setParentescoContatoDeEmergencia(String parentescoContatoDeEmergencia) {
        this.parentescoContatoDeEmergencia = parentescoContatoDeEmergencia;
    }
    
    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }
}


    