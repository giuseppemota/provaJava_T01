package empresaBus;

public class Trecho {
    private PontoParada origem;
    private PontoParada destino;
    private int intervaloEstimadoMinutos;

    // Construtor
    public Trecho(PontoParada origem, PontoParada destino, int intervaloEstimadoMinutos) {
        this.origem = origem;
        this.destino = destino;
        this.intervaloEstimadoMinutos = intervaloEstimadoMinutos;
    }

    // Métodos getters
    public PontoParada getOrigem() {
        return origem;
    }

    public PontoParada getDestino() {
        return destino;
    }

    public int getIntervaloEstimadoMinutos() {
        return intervaloEstimadoMinutos;
    }

}