package app;
import java.util.ArrayList;

public class RepositorioPessoas {
    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    public void adicionar(Pessoa p) {
        pessoas.add(p);
    }

    public Pessoa buscarPorCpf(String cpf) {
        for (Pessoa p : pessoas) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }
}
