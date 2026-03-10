package repository;

import model.Usuario;
import java.util.ArrayList;

public class UsuarioRepository implements IUsuarioRepository {

    private ArrayList<Usuario> arraylist;

    public UsuarioRepository(){
        arraylist = new ArrayList<Usuario>();
    }

    @Override
    public void adicionar(Usuario usuario){
        arraylist.add(usuario);
    }

    @Override
    public void remover(Usuario usuario){
        int i = arraylist.indexOf(usuario);
        if (i != -1){
            arraylist.remove(i);
        }
    }

    @Override
    public void editar(Usuario usuario){
        int i = arraylist.indexOf(usuario);
        if(i != -1){
            arraylist.set(i, usuario);
        }
    }

    @Override
    public boolean cadastrado(String cpf){
        boolean resposta = false;
        for(Usuario usuario : arraylist){
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
        for(Usuario usuario : arraylist){
            if(usuario.getCpf().equals(cpf)){
                usuarioProcurado = usuario;
                break;
            }
        }
        return usuarioProcurado;
    }

    public Usuario consultar(Usuario usuario){
        Usuario usuarioProcurado = null;
        for(Usuario u : arraylist){
            if(u.equals(usuario)){
                usuarioProcurado = u;
                break;
            }
        }
        return usuarioProcurado;
    }

}
