package empresaBus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Jornada {
    private Motorista motorista;
    private Veiculo veiculo;
    private Cobrador cobrador; // Opcional
    private Trajeto trajeto;
    private LocalDateTime inicioJornada;
    private LocalDateTime fimJornada;

    // Construtor
    public Jornada(Motorista motorista, Veiculo veiculo, Trajeto trajeto) {
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.trajeto = trajeto;
    }

    // Método para iniciar a jornada
    public void iniciarJornada() {
        inicioJornada = LocalDateTime.now();
    }

    // Método para encerrar a jornada
    public void encerrarJornada() {
        fimJornada = LocalDateTime.now();
    }

    public void setCobrador(Cobrador cobrador) {
        this.cobrador = cobrador;
    }

    public Cobrador getCobrador() {
        return cobrador;
    }

    // Métodos getters
    public Motorista getMotorista() {
        return motorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Trajeto getTrajeto() {
        return trajeto;
    }

    public LocalDateTime getInicioJornada() {
        return inicioJornada;
    }

    public LocalDateTime getFimJornada() {
        return fimJornada;
    }

    public static Jornada criarJornada(List<Motorista> motoristas, List<Cobrador> cobradores, List<Veiculo> veiculos,
            List<Trajeto> trajetos) {
        Scanner scanner = new Scanner(System.in);

        // Perguntar ao usuário sobre o motorista
        System.out.println("Escolha um motorista pelo nome:");
        exibirMotoristasPorNome(motoristas);
        String nomeMotoristaEscolhido = scanner.nextLine();
        Motorista motoristaEscolhido = encontrarMotoristaPorNome(motoristas, nomeMotoristaEscolhido);

        // Perguntar ao usuário sobre o veículo
        System.out.println("Escolha um veículo pela placa:");
        exibirOpcoesPorPlaca(veiculos);
        String placaVeiculoEscolhido = scanner.nextLine();
        Veiculo veiculoEscolhido = encontrarVeiculoPorPlaca(veiculos, placaVeiculoEscolhido);

        System.out.println("Escolha um trajeto pelo nome:");
        exibirTrajetosPorNome(trajetos);
        String nomeTrajetoEscolhido = scanner.nextLine();
        Trajeto trajetoEscolhido = encontrarTrajetoPorNome(trajetos, nomeTrajetoEscolhido);

        Jornada jornadaTemp = new Jornada(motoristaEscolhido, veiculoEscolhido, trajetoEscolhido);

        // Perguntar ao usuário sobre o cobrador (se necessário)
        Cobrador cobradorEscolhido = null;
        System.out.println("Deseja adicionar um cobrador? (S/N)");
        String escolhaCobrador = scanner.nextLine();
        if (escolhaCobrador.equalsIgnoreCase("S")) {
            System.out.println("Escolha um cobrador pelo nome:");
            exibirCobradoresPorNome(cobradores);
            String nomeCobradorEscolhido = scanner.nextLine();
            cobradorEscolhido = encontrarCobradorPorNome(cobradores, nomeCobradorEscolhido);
            jornadaTemp.setCobrador(cobradorEscolhido);
        }

        // Criar e retornar a jornada
        scanner.close();
        return jornadaTemp;
    }

    private static <T> void exibirMotoristasPorNome(List<T> lista) {
        for (T item : lista) {
            System.out.println(((Motorista) item).getNome());
        }
    }

    private static <T> void exibirCobradoresPorNome(List<T> lista) {
        for (T item : lista) {
            System.out.println(((Cobrador) item).getNome());
        }
    }

    private static <T> void exibirOpcoesPorPlaca(List<T> lista) {
        for (T item : lista) {
            System.out.println(((Veiculo) item).getPlaca());
        }
    }

    private static <T> void exibirTrajetosPorNome(List<T> lista) {
        for (T item : lista) {
            System.out.println(((Trajeto) item).getNome());
        }
    }

    private static Motorista encontrarMotoristaPorNome(List<Motorista> motoristas, String nome) {
        return motoristas.stream()
                .filter(motorista -> motorista.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    private static Veiculo encontrarVeiculoPorPlaca(List<Veiculo> veiculos, String placa) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    private static Cobrador encontrarCobradorPorNome(List<Cobrador> cobradores, String nome) {
        return cobradores.stream()
                .filter(cobrador -> cobrador.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    private static Trajeto encontrarTrajetoPorNome(List<Trajeto> trajetos, String nome) {
        return trajetos.stream()
                .filter(trajeto -> trajeto.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }
}