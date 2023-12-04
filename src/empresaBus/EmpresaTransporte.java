package empresaBus;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte {

    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Motorista> motoristas = new ArrayList<>();
    private List<Cobrador> cobradores = new ArrayList<>();
    private List<Passageiro> passageiros = new ArrayList<>();
    private List<Trajeto> trajetos = new ArrayList<>();
    private List<Jornada> jornadas = new ArrayList<>();
    private List<Checkpoint> checkpoints = new ArrayList<>();

    public void adicionarVeiculo() {
        veiculos.add(Veiculo.criarVeiculo(veiculos));
    }

    public void adicionarMotorista() {
        motoristas.add(Motorista.criarMotorista(motoristas));
    }

    public void adicionarCobrador() {
        cobradores.add(Cobrador.criarCobrador(cobradores));
    }

    public void adicionarPassageiro() {
        passageiros.add(Passageiro.criarPassageiro(passageiros));
    }

    public void adicionarTrajeto() {
        trajetos.add(Trajeto.criarTrajeto(trajetos));
    }

    public void adicionarJornada() {
        jornadas.add(Jornada.criarJornada(motoristas, cobradores, veiculos, trajetos));
    }

    public void adicionarCheckpoint(List<Checkpoint> checkpoits) {
        checkpoints.add(Checkpoint.criarCheckpoint(jornadas));
    }

}
