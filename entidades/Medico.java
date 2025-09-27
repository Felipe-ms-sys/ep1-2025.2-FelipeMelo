package Projeto1Poo.entidades;

public class Medico extends Pessoa{

    private String crm;
    private String especialidade;
    
    public Medico(String nome, String cpf, String email, int idade, String telefone, String sexoBiologico, String crm, String especialidade){
        super(nome, cpf, email, idade, telefone, sexoBiologico);
        this.crm = crm;
        this.especialidade = especialidade;
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
    

