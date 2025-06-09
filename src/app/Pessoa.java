package app;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String cpf;
    private ArrayList<Animal> animaisAdotados = new ArrayList<>();

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void adicionarAnimal(Animal animal) {
        animaisAdotados.add(animal);
    }

    public void removerAnimal(Animal animal) {
        animaisAdotados.remove(animal);
    }

    public String getNome() {
        return nome;
    }
}
