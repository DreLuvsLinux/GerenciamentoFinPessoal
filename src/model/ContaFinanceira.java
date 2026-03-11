package model;

import java.util.ArrayList;
import java.util.List;

public class ContaFinanceira {

    private List<Transacao> transacoes = new ArrayList<>();

    public void adicionarTransacao(Transacao t){
        transacoes.add(t);
    }

    public List<Transacao> getTransacoes(){
        return transacoes;
    }
}