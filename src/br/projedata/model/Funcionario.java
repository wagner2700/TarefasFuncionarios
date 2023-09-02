package br.projedata.model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {

    private double salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, double salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public void increaseSalary(double percent){
        if(percent > 0) {
            double increase = this.salario * (percent / 100); // Calcula o valor do aumento
            double newSalary = this.salario + increase; // Calcula o novo salário
            setSalario(newSalary); // Define o novo salário usando o método setSalario
        }
    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }




    @Override
    public String toString() {
        // formatando salario
        return super.toString() + "  Salario : R$" + String.format("%.2f",salario)  + ", Funçao : " + funcao;
    }


}
