package repository;

import model.Transacao;
import java.util.List;

public interface ITransacaoRepository {

    void salvar(String cpfUsuario. Transacao t);
    void remover(String cpfUsuario, int indice);
    List<Transacao> listar(String cpfUsuario);
}
