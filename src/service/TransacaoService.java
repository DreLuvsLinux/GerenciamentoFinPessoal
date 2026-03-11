package service;

import repository.TransacaoRepository;
import model.Transacao;

import java.util.List;

public class TransacaoService {

    private TransacaoRepository repository = new TransacaoRepository();

    public void registrarTransacao(Transacao t){
        repository.salvar(t);
    }

    public void removerTransacao(int id){
        repository.remover(id);
    }

    public List<Transacao> listarTransacoes(){
        return repository.listar();
    }

    public double calcularSaldo(){

        double saldo = 0;

        for(Transacao t : repository.listar()){

            if(t.getTipo().equalsIgnoreCase("RECEITA")){
                saldo += t.getValor();
            }else{
                saldo -= t.getValor();
            }
        }

        return saldo;
    }
}