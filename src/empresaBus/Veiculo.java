package empresaBus;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Veiculo {
    private String placa;
    private String modelo;
    private int capacidadePassageiros;
    private LocalDate dataFabricacao;
    private boolean disponivel;

    public Veiculo(String placa, String modelo, int capacidadePassageiros,
            LocalDate dataFabricacao) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadePassageiros = capacidadePassageiros;
        this.dataFabricacao = dataFabricacao;
        this.disponivel = true; // Por padrão, o veículo é considerado disponível
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Método estático para criação de um Veículo com validação de placa
    public static Veiculo criarVeiculo(List<Veiculo> veiculosCadastrados) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a placa do veículo:");
        String placa = scanner.nextLine();

        // Validar se a placa já está cadastrada
        while (placaJaCadastrada(placa, veiculosCadastrados)) {
            System.out.println("Placa já cadastrada. Digite uma placa válida:");
            placa = scanner.nextLine();
        }

        System.out.println("Digite o modelo do veículo:");
        String modelo = scanner.nextLine();

        System.out.println("Digite a capacidade de passageiros do veículo:");
        int capacidadePassageiros = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Você pode incluir lógica adicional para validar a entrada do usuário

        System.out.println("Digite a data de fabricação do veículo (formato: dd/MM/yyyy):");
        String dataFabricacaoStr = scanner.nextLine();

        // Converte a string da data de fabricação para um objeto LocalDate
        LocalDate dataFabricacao = converterStringParaLocalDate(dataFabricacaoStr);

        // Outras informações podem ser solicitadas ao usuário...
        scanner.close();
        return new Veiculo(placa, modelo, capacidadePassageiros, dataFabricacao);
    }

    // Método auxiliar para verificar se uma placa já está cadastrada
    private static boolean placaJaCadastrada(String placa, List<Veiculo> veiculos) {
        return veiculos.stream().anyMatch(veiculo -> veiculo.getPlaca().equals(placa));
    }

    // Método auxiliar para converter uma string de data para um objeto LocalDate
    private static LocalDate converterStringParaLocalDate(String dataStr) {
        return LocalDate.parse(dataStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}