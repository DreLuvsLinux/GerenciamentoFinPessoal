package repository;

import model.Transacao;
import java.util.ArrayList;
import java.util.List;

public class TransacaoRepository implements ITransacaoRepository {

    private List<Transacao> banco = new ArrayList<>();

    @Override
    public void salvar(Transacao t){
        banco.add(t);
    }

    @Override
    public void remover(int id){
        if(id >= 0 && id < banco.size()){
            banco.remove(id);
        }
    }

    @Override
    public List<Transacao> listar(){
        return banco;
    }
}