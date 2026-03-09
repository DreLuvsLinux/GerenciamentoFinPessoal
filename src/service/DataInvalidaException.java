package service;

@SuppressWarnings("serial")
public class DataInvalidaException extends UsuarioException {

    public DataInvalidaException(){
        super("Data de nascimento inválida.");
    }

}
