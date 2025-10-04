package Projeto1Poo.entidades;
import java.util.ArrayList;


public class Internacao {
    private static ArrayList<Internacao> todasInternacoes = new ArrayList<>();

    private Paciente paciente;
    private Medico medicoResponsavel;
    private String dataInternacao;
    private String dataAlta;
    private String status;
    private Leito leito;


    public Internacao(Paciente paciente, Medico medicoResponsavel, String dataInternacao, Leito leito) {
        this.paciente = paciente;
        this.medicoResponsavel = medicoResponsavel;
        this.dataInternacao = dataInternacao;
        this.leito = leito;
        this.status = "Ativa";
        this.dataAlta = null;
    }

    public static void registrarInternacao(Internacao internacao) {
        todasInternacoes.add(internacao);
    }

    public static ArrayList<Internacao> listarTodas() {
        return new ArrayList<>(todasInternacoes);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public String getDataInternacao() {
        return dataInternacao;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Leito getLeito() {
        return leito;
    }
}
