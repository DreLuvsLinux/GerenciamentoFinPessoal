package repository;

import model.Transacao;
import java.util.List;

public interface ITransacaoRepository {

    void salvar(Transacao t);
    void remover(int id);
    List<Transacao> listar();
}