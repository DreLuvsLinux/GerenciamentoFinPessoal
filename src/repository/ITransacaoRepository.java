package repository;

import java.util.List;
import model.Transacao;

public interface ITransacaoRepository {

    void salvar(String cpfUsuario, Transacao t);
    void remover(String cpfUsuario, int indice);
    List<Transacao> listar(String cpfUsuario);
}
