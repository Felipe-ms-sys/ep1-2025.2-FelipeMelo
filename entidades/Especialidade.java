package Projeto1Poo.entidades;
import java.util.ArrayList;
import java.util.List;

public enum Especialidade {
    CARDIOLOGISTA("Cardiologista", 250.00),
    NEUROLOGISTA("Neurologista", 350.00),
    ORTOPEDISTA("Ortopedista", 150.00),
    PEDIATRA("Pediatra", 200.00),
    FISIOTERAPEUTA("Fisioterapeuta", 200.00);

    private final String nome;
    private final double custo;

    Especialidade(String nome, double custo) {
        this.nome = nome;
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public double getCusto() {
        return custo;
    }

    public static Especialidade fromString(String nomeEspecialidade) {
        for (Especialidade e : Especialidade.values()) {
            if (e.nome.equalsIgnoreCase(nomeEspecialidade.trim())) {
                return e;
            }
        }
        throw new IllegalArgumentException("Especialidade inválida: " + nomeEspecialidade);
    }

    public static List<String> listarTodas() {
        List<String> nomes = new ArrayList<>();
        for (Especialidade esp : Especialidade.values()) {
            nomes.add(esp.getNome());
        }
        return nomes;
    }

    public static List<String> listarCustoEspecialidade() {
        List<String> nomes = new ArrayList<>();
        for (Especialidade esp : Especialidade.values()) {
            nomes.add(esp.getNome() + " - R$ " + esp.getCusto());
        }
        return nomes;
    }
}
   
