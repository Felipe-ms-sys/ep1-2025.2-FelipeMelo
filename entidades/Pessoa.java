package Projeto1Poo.entidades;

public class Pessoa{
    private String nome;
    private String cpf;
    private String endereço;
    private String email;
    private int idade;
    private String telefone;
    private char sexoBiologico;
    
    public Pessoa(String nome, String cpf, String endereço, String email, int idade, String telefone, char sexoBiologico){
        this.nome = nome;
        this.cpf = cpf;
        this.endereço = endereço;
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

    public String getEndereço() {
        return this.endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
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

    public char getSexo() {
        return this.sexoBiologico;
    }

    public void setSexo(char sexoBiologico) {
        this.sexoBiologico = sexoBiologico;
    }
}
