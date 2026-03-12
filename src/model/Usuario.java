package model;

import java.time.LocalDate;
/**
  Representa um usuário do sistema de gerenciamento financeiro.
  Armazena informações pessoais e limite de gastos.
  @Ana Carolina
 */
public class Usuario {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private double limiteGastos;

    public Usuario (String nome, String cpf, LocalDate dataNascimento, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.limiteGastos = 0.0;
    }

    public String getNome(){ // PRIMEIRO EXEMPLO DE ENCAPSULAMENTO !!
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public double getLimiteGastos() {
        return limiteGastos;
    }

    public void setLimiteGastos(double limiteGastos) {
        this.limiteGastos = limiteGastos;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Usuario){
            Usuario usuario = (Usuario) obj;
            if(this.cpf.equals(usuario.getCpf())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "CPF: " + cpf + "Data de nascimento: " + dataNascimento + "E-mail: " + email + " Limite de gastos: R$ " + limiteGastos;
    }

}
