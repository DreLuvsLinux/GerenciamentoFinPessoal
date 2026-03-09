package service;

@SuppressWarnings("serial")
public class UsuarioException extends Exception {

    private String aviso;

    public UsuarioException(String aviso){
        super(aviso);
        this.aviso = aviso;
    }

    @Override
    public String getMessage(){
        return aviso;
    }

}
