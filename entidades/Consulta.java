package Projeto1Poo.entidades;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Consulta {
    
    private static List<Consulta> todasConsultas = new ArrayList<>();
    
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHoraConsulta;
    private String status;
    private String diagnostico;
    private String prescricao;   
    private Local local; 


    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataConsulta, Local local) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHoraConsulta = dataConsulta;
        this.local = local;
        this.status = "Agendada";
    }

    java.time.format.DateTimeFormatter formato = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
    @Override
    public String toString() {
        return "Paciente: " + getPaciente().getNome() +
            "\nMédico: " + getMedico().getNome() +
            "\nLocal: " + getLocal().getNome() +
            "\nData e Hora: " + getDataHoraConsulta().format(formato) +
            "\nStatus: " + getStatus() +
            (diagnostico != null ? "\nDiagnóstico: " + diagnostico : "\nNão registrado") +
            (prescricao != null ? "\nPrescrição: " + prescricao : "\nNão registrada") + "\n";
    }

    public static boolean analisarConflito(Medico medico, Local local, LocalDateTime dataHora) {
        for (Consulta c : todasConsultas) {
            if (c.getDataHoraConsulta().isEqual(dataHora)) {
                if (c.getMedico().equals(medico)) {
                    return true; 
                }
                if (c.getLocal().equals(local)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void adicionarConsulta(Consulta consulta) {
        todasConsultas.add(consulta);
    }

    public static void removerConsulta(Consulta consulta) {
        todasConsultas.remove(consulta);
    }

    public static List<Consulta> listarTodas(){
        return new ArrayList<>(todasConsultas);
    }

    public Paciente getPaciente() { 
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Local getLocal(){
        return local;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

}