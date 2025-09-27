package Projeto1Poo.entidades;

public class Pessoa{
    private String nome;    
    private int idade;
    private String sexoBiologico;
    private String cpf;
    private String email;
    private String telefone;
    
    
    public Pessoa(String nome, String cpf, String email, int idade, String telefone, String sexoBiologico){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;  
        this.idade = idade;  
        this.telefone = telefone;  
        this.sexoBiologico = sexoBiologico;
    
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexoBiologico() {
        return this.sexoBiologico;
    }

    public void setSexoBiologico(String sexoBiologico) {
        this.sexoBiologico = sexoBiologico;
    }
}
