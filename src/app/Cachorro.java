package app;
public class Cachorro extends Animal {
    private String raca;
    private boolean vacinado;

    public Cachorro(String nome, int idade, String raca, boolean vacinado) {
        super(nome, idade, "Cachorro");
        this.raca = raca;
        this.vacinado = vacinado;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("[Cachorro] Nome: " + nome + ", Idade: " + idade + ", Raça: " + raca + ", Vacinado: " + vacinado);
    }
}
