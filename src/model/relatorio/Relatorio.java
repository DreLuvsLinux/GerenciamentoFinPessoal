package model.relatorio;

import model.Usuario;

public abstract class Relatorio { // ABSTRAÇÃO !! a abstração foi utilizada na classe aberta ***Relatorio***

/**
Classe abstrata que define a estrutura básica para geração
de relatórios financeiros no sistema.
 
Esta classe representa um tipo genérico de relatório e define
o método gerar(), que deve ser implementado pelas subclasses
responsáveis por relatórios específicos.

O uso dessa classe permite aplicar herança e polimorfismo
para criar diferentes tipos de relatórios a partir de uma
estrutura comum. @João Pedro */
    
    public abstract void gerar(Usuario usuario);

}
