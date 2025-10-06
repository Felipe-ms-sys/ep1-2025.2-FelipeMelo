package Projeto1Poo.entidades;
import java.util.ArrayList;
import java.util.List;

public class Leito {
    private static List<Leito> todosLeitos = new ArrayList<>();

    static{
        for (char i= 'A'; i <= 'O'; i++) {
            todosLeitos.add(new Leito(String.valueOf(i)));
        }
    }

    private String nome;
    private boolean disponibilidade;

    public Leito(String nome) {
        this.nome = nome;
        this.disponibilidade = true;
    }

    public static List<Leito> listarTodos() {
        return new ArrayList<>(todosLeitos);
    }

    public static List<Leito> listarDisponiveis() {
        List<Leito> leitosDisponiveis = new ArrayList<>();
        for (Leito lei : todosLeitos) {
            if (lei.isDisponibilidade()) {
                leitosDisponiveis.add(lei);
            }
        }
        return leitosDisponiveis;
    }

    public String getNome() {
        return nome;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    
}

