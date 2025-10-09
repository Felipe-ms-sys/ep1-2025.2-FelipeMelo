package Projeto1Poo.entidades;
import java.util.ArrayList;
import java.util.List;

public class Local {
    private static List<Local> todosLocais = new ArrayList<>();
    private String nome;

    public Local(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static void adicionarLocal(Local local) {
        todosLocais.add(local);
    }

    public static List<Local> listarTodos() {
        return new ArrayList<>(todosLocais);
    }

    public static Local buscarPorNome(String nome) {
        for (Local local : todosLocais) {
            if (local.getNome().equalsIgnoreCase(nome)) {
                return local;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return nome;
    }
}