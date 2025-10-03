package Projeto1Poo.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medico extends Pessoa{
    private static List<Medico> todosMedicos = new ArrayList<>();
    private String crm;
    private String especialidade;

    private static List<String> especialidadesDisponiveis = new ArrayList<>(Arrays.asList(
            "Cardiologista",
            "Neurologista",
            "Ortopedista"
    ));
    
    public Medico(String nome, String cpf, String email, int idade, String telefone, String sexoBiologico, String crm, String especialidade) {
        super(nome, cpf, email, idade, telefone, sexoBiologico);

        if (!especialidadesDisponiveis.contains(especialidade)) {
            throw new IllegalArgumentException("Especialidade inválida. Escolha entre: " + especialidadesDisponiveis);
        }
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public static void cadastrar(Medico medico) {
        for (Medico m : todosMedicos) {
            if (m.getCpf().equals(medico.getCpf())) {
                throw new IllegalArgumentException("Cpf já cadastrado!");
            }
        }
        todosMedicos.add(medico);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() +
        "\nCPF: " + getCpf() + 
        "\nIdade: " + getIdade() + 
        "\nEmail: " + getEmail() + 
        "\nTelefone: " + getTelefone() +
        "\nSexo Biológico: " + getSexoBiologico() + 
        "\nCRM: " + crm + 
        "\nEspecialidade: " + especialidade + "\n";
    }

    public static List<Medico> listarTodos() {
        return new ArrayList<>(todosMedicos);
    }

    public static List<String> listarEspecialidadesDisponiveis() {
        return new ArrayList<>(especialidadesDisponiveis);
    }

    public static Medico buscarMedicoPorCpf(String cpf){
        for(Medico medico : todosMedicos){
            if (medico.getCpf().equals(cpf))
            return medico;
            }
        return null;
    }

    public static void excluir(Medico medico) {
        todosMedicos.remove(medico);
    }

    public static boolean horarioOcupado(Medico medico, LocalDateTime dataHora) {
        for (Consulta i : Consulta.listarTodas()) {
            if (i.getMedico().equals(medico) && i.getDataHoraConsulta().isEqual(dataHora)) {
                return true; 
            }
        }
        return false; 
    }

    public String getCrm(){
        return crm;
    }

    public void setCrm(String crm){
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        if (!especialidadesDisponiveis.contains(especialidade)) {
            throw new IllegalArgumentException("Especialidade inválida. Escolha entre: " + especialidadesDisponiveis);
        }
        this.especialidade = especialidade;
    }
    
}
    

