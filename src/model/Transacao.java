package model;

public class Transacao {

    private double valor;
    private String descricao;
    private String tipo; // receita ou despesa

    public Transacao(double valor, String descricao, String tipo) {
        this.valor = valor;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return descricao + " - " + tipo + " - R$ " + valor;
    }
}
