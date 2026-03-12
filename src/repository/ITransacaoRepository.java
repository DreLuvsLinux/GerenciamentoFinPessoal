package repository;

import java.util.List;
import model.Transacao;

/**
Interface responsável por definir as operações básicas
de armazenamento e recuperação de transações financeiras.

Permite que diferentes implementações de repositório sejam
utilizadas sem impactar as outras camadas do sistema. @André */

public interface ITransacaoRepository {

    void salvar(String cpfUsuario, Transacao t);
    void remover(String cpfUsuario, int indice);
    List<Transacao> listar(String cpfUsuario);
}

