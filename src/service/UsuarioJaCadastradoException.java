package service;

@SuppressWarnings("serial")
public class UsuarioJaCadastradoException extends UsuarioException {

    public UsuarioJaCadastradoException(){
        super("Um usuário com este CPF já foi cadastrado.");
    }
}
