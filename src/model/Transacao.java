package model;

import java.time.LocalDate;

public class Transacao {

    private int id;
    private double valor;
    private String descricao;
    private LocalDate data;
    private String tipo; // RECEITA ou DESPESA
    private Categoria categoria;

    public Transacao(int id, double valor, String descricao, LocalDate data, String tipo, Categoria categoria) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public int getId() { return id; }
    public double getValor() { return valor; }
    public String getDescricao() { return descricao; }
    public LocalDate getData() { return data; }
    public String getTipo() { return tipo; }
    public Categoria getCategoria() { return categoria; }

    public void setValor(double valor) { this.valor = valor; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}