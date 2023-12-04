package empresaBus;

public class Cartao {
    private String numero;
    private double saldo;
    private String tipo; // Pode ser "estudante", "idoso", "transporte" etc.
    private boolean ativo;

    public Cartao(String numero, double saldo, String tipo) {
        this.numero = numero;
        this.saldo = saldo;
        this.tipo = tipo;
        this.ativo = true; // Por padrão, o cartão é considerado ativo
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setSaldo(double novoSaldo) {
        this.saldo = novoSaldo;
    }

    public void desativarCartao() {
        this.ativo = false;
    }

    public void ativarCartao() {
        this.ativo = true;
    }
}
