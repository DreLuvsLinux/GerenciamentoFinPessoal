package service.exceptions;

@SuppressWarnings("serial")
public class DataInvalidaException extends UsuarioException {

    public DataInvalidaException(){
        super("Data de nascimento inválida.");
    }

}
