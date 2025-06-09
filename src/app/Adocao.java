package app;
import java.time.LocalDate;

public class Adocao {
    private Pessoa adotante;
    private Animal animal;
    private LocalDate dataAdocao;

    public Adocao(Pessoa adotante, Animal animal) {
        this.adotante = adotante;
        this.animal = animal;
        this.dataAdocao = LocalDate.now();
    }

    public Animal getAnimal() {
        return animal;
    }

    public Pessoa getAdotante() {
        return adotante;
    }

    public void exibir() {
        System.out.println("Animal: " + animal.getNome() + ", Adotado por: " + adotante.getNome() + ", Data: " + dataAdocao);
    }
}