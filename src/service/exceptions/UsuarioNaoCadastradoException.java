package service.exceptions;

@SuppressWarnings("serial")
public class UsuarioNaoCadastradoException extends UsuarioException {

    public UsuarioNaoCadastradoException(){
        super("Não há usuário cadastrado com esse CPF.");
    }
}
