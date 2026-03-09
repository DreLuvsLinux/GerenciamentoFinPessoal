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

}
