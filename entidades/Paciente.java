package Projeto1Poo.entidades;
// import java.util.List;

public class Paciente extends Pessoa {
    private String numeroProntuario;
    /*private String dataCadrastro;
    private String planodesaude;

    private String dataSaida;
    private String Status;
    private String historico;

    private String tipoSanguineo;
    private List<String> alergias;
    private List<String> medicamentosEmUso;

    private String nomeContatoEmergencia;
    private String numeroContatoEmergencia;
    private String parentescoContatoDeEmergência;*/




    public Paciente(String nome, String cpf, String endereço, String email, int idade, String telefone, char sexoBiologico, String numeroProntuario){

        super(nome, cpf, endereço, email, idade, telefone, sexoBiologico);
        this.numeroProntuario = numeroProntuario;
    }

    public String getNumeroProntuario(){
        return numeroProntuario;
    }
    
    public void setNumeroPronturario(String numeroProntuario){
    this.numeroProntuario = numeroProntuario;
    }  
    
}
