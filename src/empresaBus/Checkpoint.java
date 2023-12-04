package empresaBus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Checkpoint {
    private PontoParada pontoParada;
    private Veiculo veiculo;
    private Trecho trecho;
    private LocalDateTime horarioChegada;

    // Construtor
    public Checkpoint(PontoParada pontoParada, Veiculo veiculo, Trecho trecho) {
        this.pontoParada = pontoParada;
        this.veiculo = veiculo;
        this.trecho = trecho;
        this.horarioChegada = LocalDateTime.now(); // Define o horário de chegada como o momento da criação do
                                                   // checkpoint
    }

    // Métodos getters
    public PontoParada getPontoParada() {
        return pontoParada;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Trecho getTrecho() {
        return trecho;
    }

    public LocalDateTime getHorarioChegada() {
        return horarioChegada;
    }

    // Método estático para criar um checkpoint
    public static Checkpoint criarCheckpoint(List<Jornada> jornadas) {
        Scanner scanner = new Scanner(System.in);

        // Perguntar ao usuário sobre a jornada
        System.out.println("Escolha uma jornada para criar um checkpoint:");
        exibirOpcoesJornadas(jornadas);
        int indiceJornadaEscolhida = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Jornada jornadaEscolhida = jornadas.get(indiceJornadaEscolhida - 1);

        // Perguntar ao usuário sobre o ponto de parada
        System.out.println("Digite o nome do ponto de parada:");
        String nomePontoParada = scanner.nextLine();
        PontoParada pontoParada = new PontoParada(nomePontoParada);

        // Criar e retornar o checkpoint
        scanner.close();
        return new Checkpoint(pontoParada, jornadaEscolhida.getVeiculo(), jornadaEscolhida.getTrajeto().getTrecho(0));
    }

    private static void exibirOpcoesJornadas(List<Jornada> jornadas) {
        for (int i = 0; i < jornadas.size(); i++) {
            System.out.println((i + 1) + ". Jornada de " + jornadas.get(i).getMotorista().getNome());
        }
    }
}