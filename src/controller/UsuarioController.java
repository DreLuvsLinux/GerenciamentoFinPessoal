package controller;

import model.Usuario;
import service.CpfInvalidoException;
import service.DataInvalidaException;
import service.UsuarioJaCadastradoException;
import service.UsuarioNaoCadastradoException;
import service.UsuarioService;

public class UsuarioController {

    private UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    public void adicionar(Usuario usuario) 
        throws UsuarioJaCadastradoException, CpfInvalidoException, DataInvalidaException {
        service.adicionar(usuario);
    }

    public void remover(String cpf) throws UsuarioNaoCadastradoException {
        service.remover(cpf);
    }

    public void editar(Usuario usuario) throws UsuarioNaoCadastradoException {
        service.editar(usuario);
    }

    public Usuario consultar(String cpf) {
        return service.consultar(cpf);
    }

    public Usuario login(String cpf) throws UsuarioNaoCadastradoException {
        return service.login(cpf);
    }

}
