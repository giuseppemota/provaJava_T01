package empresaBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trajeto {
    private String nome;
    private List<Trecho> trechos;

    public Trajeto(String nome) {
        this.trechos = new ArrayList<>();
        this.nome = nome;
    }

    public Trecho getTrecho(int index) {
        if (trechos != null && index >= 0 && index < trechos.size()) {
            return trechos.get(index);
        }
        return null;
    }

    // Método para adicionar um trecho ao trajeto

    public void adicionarTrecho() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ponto de origem:");
        String origemNome = scanner.nextLine();
        PontoParada origem = new PontoParada(origemNome);

        System.out.println("Digite o ponto de destino:");
        String destinoNome = scanner.nextLine();
        PontoParada destino = new PontoParada(destinoNome);

        System.out.println("Digite o intervalo estimado em minutos:");
        int intervaloEstimadoMinutos = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        scanner.close();
        Trecho novoTrecho = new Trecho(origem, destino, intervaloEstimadoMinutos);
        trechos.add(novoTrecho);
    }

    public List<Trecho> getTrechos() {
        return trechos;
    }

    public String getNome() {
        return nome;
    }

    public static Trajeto criarTrajeto(List<Trajeto> trajetos) {
        // peça ao usuario para digitar o nome do trajeto e verifique se existe na List
        System.out.println("Digite o nome do trajeto:");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();

        Trajeto trajetoTemp = new Trajeto(nome);
        String continuar = "s";
        while (continuar.equals("s")) {
            System.out.println("Deseja adicionar um novo trecho? (s/n)");

            continuar = scanner.nextLine();
        }
        scanner.close();
        return trajetoTemp;
    }
}
