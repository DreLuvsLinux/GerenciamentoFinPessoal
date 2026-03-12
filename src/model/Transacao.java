package model;

/**
Representa uma transação financeira registrada pelo usuário.
Uma transação pode ser do tipo RECEITA ou DESPESA e contém
informações como descrição e valor.

As transações são utilizadas para cálculo de saldo e geração
de relatórios financeiros no sistema. @André */

public class Transacao {

    private double valor;
    private String descricao;
    private String tipo; // receita ou despesa

    public Transacao(String descricao, double valor, String tipo) {
        this.descricao = descricao;
        this.valor = valor;
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


