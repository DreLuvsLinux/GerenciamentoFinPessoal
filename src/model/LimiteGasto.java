package model;

public class LimiteGasto {

    private Categoria categoria;
    private double limite;

    public LimiteGasto(Categoria categoria, double limite){
        this.categoria = categoria;
        this.limite = limite;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public double getLimite(){
        return limite;
    }
}