package app;
import java.util.ArrayList;

public class RepositorioAnimais {
    private ArrayList<Animal> animais = new ArrayList<>();

    public void adicionar(Animal a) {
        animais.add(a);
    }

    public void remover(Animal a) {
        animais.remove(a);
    }

    public ArrayList<Animal> listarDisponiveis(ArrayList<Adocao> adocoes) {
        ArrayList<Animal> disponiveis = new ArrayList<>(animais);
        for (Adocao a : adocoes) {
            disponiveis.remove(a.getAnimal());
        }
        return disponiveis;
    }

    public Animal buscarPorNome(String nome) {
        for (Animal a : animais) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }
}