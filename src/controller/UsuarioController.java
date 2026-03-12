package controller;

import model.Usuario;
import service.UsuarioService;
import service.exceptions.CpfInvalidoException;
import service.exceptions.DataInvalidaException;
import service.exceptions.UsuarioJaCadastradoException;
import service.exceptions.UsuarioNaoCadastradoException;

public class UsuarioController {

    private UsuarioService service;

    public UsuarioController() { // Adicionei um construtor vazio pra rodar na main
        this.service = new UsuarioService();
    }

    public UsuarioController(UsuarioService service) { // injeção de dependência (parcial), recebendo UsuarioService de fora
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
