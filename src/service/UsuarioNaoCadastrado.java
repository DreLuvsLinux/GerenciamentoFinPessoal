package service;

@SuppressWarnings("serial")
public class UsuarioNaoCadastrado extends UsuarioException {

    public UsuarioNaoCadastrado(){
        super("Não há usuário cadastrado com esse CPF.");
    }
}
