package Projeto1Poo.entidades;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Internacao {
    private static ArrayList<Internacao> todasInternacoes = new ArrayList<>();
    private static double custoDiaria = 300.0;

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

    public static void adicionarInternacao(Internacao internacao) {
        todasInternacoes.add(internacao);
    }

    public static void removerInternacao(Internacao internacao) {
    todasInternacoes.remove(internacao);
    }

    public static ArrayList<Internacao> listarTodas() {
        return new ArrayList<>(todasInternacoes);
    }

    public long getDuracaoEmDias() {
        if (dataAlta == null || dataInternacao == null || dataAlta.isEmpty() || dataInternacao.isEmpty()) {
            return 0;
        }
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime inicio = LocalDateTime.parse(dataInternacao, formato);
            LocalDateTime fim = LocalDateTime.parse(dataAlta, formato);
            
            long dias = ChronoUnit.DAYS.between(inicio, fim);
            return dias == 0 ? 1 : dias; 
        } catch (java.time.format.DateTimeParseException e) {
            System.err.println("Erro ao calcular duração da internação: formato de data inválido.");
            return 0;
        }
    }

    public double calcularCusto() {
        long dias = getDuracaoEmDias();
        if (dias <= 0) {
            return 0;
        }

        Convenio convenio = this.getPaciente().getConvenio();
        if (convenio != null && "Internação".equalsIgnoreCase(convenio.getTipoDePlano()) && dias <= 7) {
            return 0.0;
        }

        return dias * custoDiaria;
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
