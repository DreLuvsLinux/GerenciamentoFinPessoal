package service;

import java.time.LocalDate;

import model.Usuario;
import repository.IUsuarioRepository;
import repository.UsuarioRepository;
import service.exceptions.CpfInvalidoException;
import service.exceptions.DataInvalidaException;
import service.exceptions.UsuarioJaCadastradoException;
import service.exceptions.UsuarioNaoCadastradoException;

/**
Classe responsável pelas regras de negócio relacionadas
ao gerenciamento de usuários do sistema.

Realiza operações como cadastro, remoção, edição,
validação de CPF e validação de data de nascimento.

Atua como intermediária entre o controller e o repositório. @Ana Carolina */

public class UsuarioService {

    private IUsuarioRepository repositorio;

    public UsuarioService() {
        this.repositorio = new UsuarioRepository();
    }

    public UsuarioService(IUsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionar(Usuario usuario)
            throws UsuarioJaCadastradoException, CpfInvalidoException, DataInvalidaException {

        validarCpf(usuario.getCpf());
        validarDataNascimento(usuario.getDataNascimento());

        if (repositorio.cadastrado(usuario.getCpf())) {
            throw new UsuarioJaCadastradoException();
        }

        repositorio.adicionar(usuario);
    }

    public void remover(String cpf) throws UsuarioNaoCadastradoException {
        Usuario usuario = repositorio.consultar(cpf);

        if (usuario != null) {
            repositorio.remover(usuario);
        } else {
            throw new UsuarioNaoCadastradoException();
        }
    }

    public void editar(Usuario usuario) throws UsuarioNaoCadastradoException {
        Usuario usuarioEncontrado = repositorio.consultar(usuario.getCpf());

        if (usuarioEncontrado != null) {
            repositorio.editar(usuario);
        } else {
            throw new UsuarioNaoCadastradoException();
        }
    }

    public Usuario consultar(String cpf) {
        return repositorio.consultar(cpf);
    }

    public Usuario login(String cpf) throws UsuarioNaoCadastradoException {
        Usuario usuario = repositorio.consultar(cpf);

        if (usuario == null) {
            throw new UsuarioNaoCadastradoException();
        }

        return usuario;
    }

    public void validarCpf(String cpf) throws CpfInvalidoException {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new CpfInvalidoException();
        }
    }

    private void validarDataNascimento(LocalDate data) throws DataInvalidaException {
        if (data == null || data.isAfter(LocalDate.now()) || data.isBefore(LocalDate.now().minusYears(120))) {
            throw new DataInvalidaException();
        }
    }
}
