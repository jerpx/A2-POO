package app;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RepositorioAnimais repoAnimais = new RepositorioAnimais();
        RepositorioPessoas repoPessoas = new RepositorioPessoas();
        ServicoAdocao servico = new ServicoAdocao();

        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar novo animal");
            System.out.println("2. Cadastrar nova pessoa");
            System.out.println("3. Listar animais disponíveis");
            System.out.println("4. Realizar adoção");
            System.out.println("5. Cancelar adoção");
            System.out.println("6. Listar adoções");
            System.out.println("0. Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Tipo (1-Cachorro / 2-Gato): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    if (tipo == 1) {
                        System.out.print("Raça: ");
                        String raca = sc.nextLine();
                        System.out.print("Vacinado (true/false): ");
                        boolean vacinado = sc.nextBoolean();
                        repoAnimais.adicionar(new Cachorro(nome, idade, raca, vacinado));
                    } else {
                        System.out.print("Cor: ");
                        String cor = sc.nextLine();
                        System.out.print("Castrado (true/false): ");
                        boolean castrado = sc.nextBoolean();
                        repoAnimais.adicionar(new Gato(nome, idade, cor, castrado));
                    }
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nomePessoa = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    repoPessoas.adicionar(new Pessoa(nomePessoa, cpf));
                    break;
                case 3:
                    for (Animal a : repoAnimais.listarDisponiveis(servico.getAdocoes())) {
                        a.exibirInformacoes();
                    }
                    break;
                case 4:
                    System.out.print("CPF do adotante: ");
                    String cpfAd = sc.nextLine();
                    Pessoa p = repoPessoas.buscarPorCpf(cpfAd);
                    System.out.print("Nome do animal: ");
                    String nomeAnimal = sc.nextLine();
                    Animal a = repoAnimais.buscarPorNome(nomeAnimal);
                    if (p != null && a != null) {
                        boolean sucesso = servico.realizarAdocao(p, a);
                        System.out.println(sucesso ? "Adoção realizada com sucesso." : "Animal já foi adotado.");
                    } else {
                        System.out.println("Pessoa ou animal não encontrados.");
                    }
                    break;
                case 5:
                    System.out.print("CPF do adotante: ");
                    String cpfCanc = sc.nextLine();
                    Pessoa pc = repoPessoas.buscarPorCpf(cpfCanc);
                    System.out.print("Nome do animal: ");
                    String nomeCanc = sc.nextLine();
                    Animal ac = repoAnimais.buscarPorNome(nomeCanc);
                    if (pc != null && ac != null) {
                        servico.cancelarAdocao(pc, ac);
                        System.out.println("Adoção cancelada.");
                    } else {
                        System.out.println("Pessoa ou animal não encontrados.");
                    }
                    break;
                case 6:
                    servico.listarAdocoes();
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}
