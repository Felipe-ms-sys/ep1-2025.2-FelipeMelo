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


public Consulta(Paciente paciente, Medico medico, LocalDateTime dataConsulta) {
    this.paciente = paciente;
    this.medico = medico;
    this.dataHoraConsulta = dataConsulta;
    this.status = "Agendada";
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