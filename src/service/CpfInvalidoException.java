package service;

@SuppressWarnings("serial")
public class CpfInvalidoException extends UsuarioException {

    public CpfInvalidoException(){
        super("O CPF não pode ser nulo e deve ter 11 dígitos numéricos.");
    }

}
