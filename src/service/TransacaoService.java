package service;

import model.Transacao;
import model.Usuario;
import repository.TransacaoRepository;

import java.util.List;

public class TransacaoService {

    private TransacaoRepository repository = new TransacaoRepository();

    public String registrarTransacao(Usuario usuario, Transacao t) {
/**
Registra uma nova transação para o usuário informado.

Caso a transação seja uma despesa, o método verifica
se o valor ultrapassa o limite de gastos definido pelo o usuário.

Se ultrapassar, a transação pode ser bloqueada. @André*/

        if (t.getTipo().equalsIgnoreCase("DESPESA")) {
            double limite = usuario.getLimiteGastos();
            double valor = t.getValor();

            if (limite > 0) {
                if (valor > limite) {
                    return "BLOQUEADA";
                } else if (valor == limite) {
                    repository.salvar(usuario.getCpf(), t);
                    return "ATINGIU_LIMITE";
                } else if (valor >= limite * 0.8) {
                    repository.salvar(usuario.getCpf(), t);
                    return "PROXIMA_DO_LIMITE";
                }
            }
        }

        repository.salvar(usuario.getCpf(), t);
        return "OK";
    }

    public void removerTransacao(Usuario usuario, int indice) {
        repository.remover(usuario.getCpf(), indice);
    }

    public List<Transacao> listarTransacoes(Usuario usuario) {
        return repository.listar(usuario.getCpf());
    }

    public double calcularSaldo(Usuario usuario) {
        double saldo = 0;

        for (Transacao t : repository.listar(usuario.getCpf())) {
            if (t.getTipo().equalsIgnoreCase("RECEITA")) {
                saldo += t.getValor();
            } else {
                saldo -= t.getValor();
            }
        }

        return saldo;
    }

    public double calcularTotalDespesas(Usuario usuario) {
        double total = 0;

        for (Transacao t : repository.listar(usuario.getCpf())) {
            if (t.getTipo().equalsIgnoreCase("DESPESA")) {
                total += t.getValor();
            }
        }

        return total;
    }
}


