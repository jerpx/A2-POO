package app;
public class Gato extends Animal {
    private String cor;
    private boolean castrado;

    public Gato(String nome, int idade, String cor, boolean castrado) {
        super(nome, idade, "Gato");
        this.cor = cor;
        this.castrado = castrado;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("[Gato] Nome: " + nome + ", Idade: " + idade + ", Cor: " + cor + ", Castrado: " + castrado);
    }
}
