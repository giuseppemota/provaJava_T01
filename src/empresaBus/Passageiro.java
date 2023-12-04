package empresaBus;

import java.util.List;
import java.util.Scanner;

public class Passageiro {
    private String nome;
    private String cpf;
    private String tipoCartao; // Pode ser "estudante", "idoso", "transporte" etc.

    public Passageiro(String nome, String cpf, String tipoCartao) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipoCartao = tipoCartao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    // Método estático para criação de um Passageiro com validação de CPF
    public static Passageiro criarPassageiro(List<Passageiro> passageirosCadastrados) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do passageiro:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF do passageiro:");
        String cpf = scanner.nextLine();

        // Validar se o CPF já está cadastrado
        while (cpfJaCadastrado(cpf, passageirosCadastrados)) {
            System.out.println("CPF já cadastrado. Digite um CPF válido:");
            cpf = scanner.nextLine();
        }

        System.out.println("Digite o tipo de cartão do passageiro:");
        String tipoCartao = scanner.nextLine();

        // Outras informações podem ser solicitadas ao usuário...
        scanner.close();
        return new Passageiro(nome, cpf, tipoCartao);
    }

    // Método auxiliar para verificar se um CPF já está cadastrado
    private static boolean cpfJaCadastrado(String cpf, List<Passageiro> passageiros) {
        return passageiros.stream().anyMatch(passageiro -> passageiro.getCpf().equals(cpf));
    }
}
