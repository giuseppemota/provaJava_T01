package empresaBus;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Cobrador {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private boolean disponivel;

    public Cobrador(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.disponivel = true; // Por padrão, o cobrador é considerado disponível
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public static Cobrador criarCobrador(List<Cobrador> cobradoresCadastrados) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cobrador:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF do cobrador:");
        String cpf = scanner.nextLine();

        // Validar se o CPF já está cadastrado
        while (cpfJaCadastrado(cpf, cobradoresCadastrados)) {
            System.out.println("CPF já cadastrado. Digite um CPF válido:");
            cpf = scanner.nextLine();
        }

        System.out.println("Digite a data de nascimento do cobrador (formato: dd/MM/yyyy):");
        String dataNascimentoStr = scanner.nextLine();

        // Converte a string da data de nascimento para um objeto LocalDate
        LocalDate dataNascimento = converterStringParaLocalDate(dataNascimentoStr);

        // Outras informações podem ser solicitadas ao usuário...
        scanner.close();
        return new Cobrador(nome, cpf, dataNascimento);
    }

    // Método auxiliar para verificar se um CPF já está cadastrado
    private static boolean cpfJaCadastrado(String cpf, List<Cobrador> cobradores) {
        return cobradores.stream().anyMatch(cobrador -> cobrador.getCpf().equals(cpf));
    }

    // Método auxiliar para converter uma string de data para um objeto LocalDate
    private static LocalDate converterStringParaLocalDate(String dataStr) {
        return LocalDate.parse(dataStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
