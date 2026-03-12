package controller;

import model.Transacao;
import model.Usuario;
import service.TransacaoService;

import java.util.List;

public class TransacaoController {

    private TransacaoService service = new TransacaoService();

    public String registrar(Usuario usuario, Transacao t) {
        return service.registrarTransacao(usuario, t);
    }

    public void remover(Usuario usuario, int indice) {
        service.removerTransacao(usuario, indice);
    }

    public List<Transacao> listar(Usuario usuario) {
        return service.listarTransacoes(usuario);
    }

    public double saldo(Usuario usuario) {
        return service.calcularSaldo(usuario);
    }

    public double totalDespesas(Usuario usuario) {
        return service.calcularTotalDespesas(usuario);
    }
}
