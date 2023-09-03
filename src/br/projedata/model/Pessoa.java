package br.projedata.model;

import java.time.LocalDate;

public class Pessoa {
    private String nome ;
    private LocalDate dataNascimento;


    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade(){
        LocalDate dataAtual = LocalDate.now();

        int idade = dataAtual.getYear() - dataNascimento.getYear();
        return idade;
    }

    @Override
    public String toString() {
        return "Nome : " + nome  + ", Data Nascimento : " + dataNascimento ;
    }
}
