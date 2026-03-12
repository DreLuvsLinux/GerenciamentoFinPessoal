package repository;

import model.Usuario;

/**
Interface que define as operações de acesso e manipulação
de usuários no sistema.

Seu objetivo é desacoplar a lógica de negócio da implementação
concreta de armazenamento de dados, permitindo diferentes
implementações de repositório. @Ana Carolina */

public interface IUsuarioRepository {

    void adicionar(Usuario usuario);

    void remover(Usuario usuario);

    void editar(Usuario usuario);

    boolean cadastrado(String cpf);

    Usuario consultar(String cpf);

// Removi a consulta por usuario pra consultarmos apenas por um identificador (CPF) @André

}
