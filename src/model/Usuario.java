package model;

import java.time.LocalDate;

public class Usuario {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;

    public Usuario (String nome, String cpf, LocalDate dataNascimento, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public String getNome(){
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

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Usuario){
            Usuario usuario = (Usuario) obj;
            if(this.cpf.equals(getCpf())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "CPF: " + cpf + "Data de nascimento: " + dataNascimento + "E-mail: " + email;
    }

}
