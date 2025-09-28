package Projeto1Poo.entidades;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa{
    private static List<Medico> todosMedicos = new ArrayList<>();
    private String crm;
    private String especialidade;
    
    public Medico(String nome, String cpf, String email, int idade, String telefone, String sexoBiologico, String crm, String especialidade){
        super(nome, cpf, email, idade, telefone, sexoBiologico);
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

    public String getCrm(){
        return crm;
    }

    public void setCrm(String crm){
        this.crm = crm;
    }
    
    public String getEspecialidade(){
        return especialidade;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }

    
}
    

