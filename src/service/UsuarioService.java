package service;

import java.time.LocalDate;
import model.Usuario;
import repository.IUsuarioRepository;
import service.exceptions.CpfInvalidoException;
import service.exceptions.DataInvalidaException;
import service.exceptions.UsuarioJaCadastradoException;
import service.exceptions.UsuarioNaoCadastradoException;

public class UsuarioService {

    private IUsuarioRepository repositorio;

    public UsuarioService() {
        this.repositorio = new UsuarioRepository.java();  // Adicionei o construtor vazio
    }
    
    public UsuarioService(IUsuarioRepository repositorio){
        this.repositorio = repositorio;
    }

    public void adicionar(Usuario usuario) 
        throws UsuarioJaCadastradoException, CpfInvalidoException, DataInvalidaException {

        validarCpf(usuario.getCpf());
        validarDataNascimento(usuario.getDataNascimento());

        boolean cadastrado = repositorio.cadastrado(usuario.getCpf());

        if(cadastrado){
            throw new UsuarioJaCadastradoException();
        }else{
            repositorio.adicionar(usuario);
        }
    }

    public void remover(String cpf) throws UsuarioNaoCadastradoException {
        Usuario usuario = repositorio.consultar(cpf);
        if(usuario != null){
            repositorio.remover(usuario);
        }else{
            throw new UsuarioNaoCadastradoException();
        }
    }

    public void editar(Usuario usuario) throws UsuarioNaoCadastradoException {
        Usuario u = repositorio.consultar(usuario.getCpf());  // get.Cpf pra buscar um cpf no repositório já que não vamos usar o usuario para buscar
        if(u != null){
            repositorio.editar(usuario);
        }else{
            throw new UsuarioNaoCadastradoException();
        }
    }

    public Usuario consultar(String cpf) {
        return repositorio.consultar(cpf);
    }

    public void validarCpf(String cpf) throws CpfInvalidoException {
        if(cpf == null || !cpf.matches("\\d{11}")){
            throw new CpfInvalidoException();
        }
    }

    private void validarDataNascimento(LocalDate data) 
        throws DataInvalidaException {

        if (data.isAfter(LocalDate.now())) {
            throw new DataInvalidaException();
        }

        if (data.isBefore(LocalDate.now().minusYears(120))) {
            throw new DataInvalidaException();
        }
    }

    public Usuario login(String cpf) throws UsuarioNaoCadastradoException {

        Usuario usuario = repositorio.consultar(cpf);

        if(usuario == null){
            throw new UsuarioNaoCadastradoException();
        }

        return usuario;
    }

}
