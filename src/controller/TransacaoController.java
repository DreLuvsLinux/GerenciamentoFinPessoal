package controller;

import service.TransacaoService;
import model.Transacao;

import java.util.List;

public class TransacaoController {

    private TransacaoService service = new TransacaoService();

    public void registrar(Transacao t){
        service.registrarTransacao(t);
    }

    public void remover(int id){
        service.removerTransacao(id);
    }

    public List<Transacao> listar(){
        return service.listarTransacoes();
    }

    public double saldo(){
        return service.calcularSaldo();
    }
}