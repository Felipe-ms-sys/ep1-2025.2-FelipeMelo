package Projeto1Poo.entidades;

public class Neurologista extends Medico {
    public Neurologista(String nome, String cpf, String email, int idade, String telefone, String sexoBiologico, String crm) {
        super(nome, cpf, email, idade, telefone, sexoBiologico, crm);
    }
    
    @Override
    public String getEspecialidade() {
        return "Neurologista";
    }
}
