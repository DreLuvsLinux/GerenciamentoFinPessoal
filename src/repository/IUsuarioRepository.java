package repository;

import model.Usuario;

public interface IUsuarioRepository {

    void adicionar(Usuario usuario);

    void remover(Usuario usuario);

    void editar(Usuario usuario);

}
