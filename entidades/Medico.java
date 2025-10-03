package Projeto1Poo.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Medico extends Pessoa{
    private static List<Medico> todosMedicos = new ArrayList<>();
    private String crm;
    
    public Medico(String nome, String cpf, String email, int idade, String telefone, String sexoBiologico, String crm){
        super(nome, cpf, email, idade, telefone, sexoBiologico);
        this.crm = crm;
        
    }

    public static void cadastrar(Medico medico) {
        for (Medico m : todosMedicos) {
            if (m.getCpf().equals(medico.getCpf())) {
                throw new IllegalArgumentException("Cpf já cadastrado!");
            }
        }
        todosMedicos.add(medico);
    }

    public static List<Medico> listarTodos() {
        return new ArrayList<>(todosMedicos);
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

    public abstract String getEspecialidade();
    
}
    

