package repository;

import model.Transacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransacaoRepository implements ITransacaoRepository {

    private Map<String, List<Transacao>> banco = new HashMap<>();

    @Override
    public void salvar(String cpfUsuario, Transacao t) {
        banco.putIfAbsent(cpfUsuario, new ArrayList<>());
        banco.get(cpfUsuario).add(t);
    }

    @Override
    public void remover(String cpfUsuario, int indice) {
        List<Transacao> transacoes = banco.get(cpfUsuario);

        if (transacoes != null && indice >= 0 && indice < transacoes.size()) {
            transacoes.remove(indice);
        }
    }

    @Override
    public List<Transacao> listar(String cpfUsuario) {
        banco.putIfAbsent(cpfUsuario, new ArrayList<>());
        return banco.get(cpfUsuario);
    }
}
