package repository;

import model.Usuario;

public interface IUsuarioRepository {

    void adicionar(Usuario usuario);

    void remover(Usuario usuario);

    void editar(Usuario usuario);

    boolean cadastrado(String cpf);

    Usuario consultar(String cpf);

// Removi a consulta por usuario pra consultarmos apenas por um identificador (CPF)

}
