package repository;

import model.Usuario;
import java.util.ArrayList;

public class UsuarioRepository implements IUsuarioRepository {

    private ArrayList<Usuario> usuarios;  // Só troquei a variavel para usuarios pra ficar mais claro :p

    public UsuarioRepository(){
        usuarios = new ArrayList<Usuario>();
    }

    @Override
    public void adicionar(Usuario usuario){
        usuarios.add(usuario);
    }

    @Override
    public void remover(Usuario usuario){
        int i = usuarios.indexOf(usuario);
        if (i != -1){
            usuarios.remove(i);
        }
    }

    @Override
    public void editar(Usuario usuario){
        int i = usuarios.indexOf(usuario);
        if(i != -1){
            usuarios.set(i, usuario);
        }
    }

    @Override
    public boolean cadastrado(String cpf){
        boolean resposta = false;
        for(Usuario usuario : usuarios){
            if(usuario.getCpf().equals(cpf)){
                resposta = true;
                break;
            }
        }
        return resposta;
    }

    @Override
    public Usuario consultar(String cpf){
        Usuario usuarioProcurado = null;
        for(Usuario usuario : usuarios){
            if(usuario.getCpf().equals(cpf)){
                usuarioProcurado = usuario;
                break;
            }
        }
        return usuarioProcurado;
    }

    public Usuario consultar(Usuario usuario){
        Usuario usuarioProcurado = null;
        for(Usuario u : usuarios){
            if(u.equals(usuario)){
                usuarioProcurado = u;
                break;
            }
        }
        return usuarioProcurado;
    }

}
