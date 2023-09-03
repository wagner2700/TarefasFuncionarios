import br.projedata.model.Funcionario;
import br.projedata.model.Pessoa;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class Main {
    public static void main(String[] args) {
        //3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), 2009.44, "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 05, 12), 2284.38, "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961 , 05, 02), 9836.14, "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), 19119.88, "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 01, 05), 2234.68, "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), 1582.72, "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), 4071.84, "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 07, 8), 3017.45, "Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 05, 24), 1606.85, "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 02), 2799.93, "Gerente"));




        // Formata o valor numérico
        NumberFormat format = DecimalFormat.getNumberInstance();
        format.setGroupingUsed(true);

        System.out.println();
        System.out.println("Imprimir todos os funcionários com todas suas informações");
        // 3.3 – Imprimir todos os funcionários com todas suas informações
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data Nascimento: " + formatter.format(funcionario.getDataNascimento()));
            System.out.println("Salário: " + format.format(funcionario.getSalario()));
            System.out.println("Cargo: " + funcionario.getFuncao());
            System.out.println();
        }

        System.out.println();
        // 3.2 – Remover o funcionário “João” da lista.
        System.out.println(" Remover o funcionário “João” da lista.");
        String remover = "João";
        Iterator<Funcionario> iterator = funcionarios.iterator();
        while (iterator.hasNext()) {
            Pessoa pessoa = iterator.next();
            if (pessoa.getNome().equals(remover)) {
                iterator.remove();
                System.out.println(remover + "Foi removido da lista");
            }
        }

        // Imprimindo a lista para exibir a lista atualizada
        System.out.println("Imprimindo a lista para exibir a lista atualizada");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        System.out.println();
        System.out.println();

        //3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        System.out.println("Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor");
        for (Funcionario funcionario : funcionarios) {
            funcionario.increaseSalary(10);
            System.out.println(funcionario);
        }

        System.out.println();
        System.out.println();

        // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        System.out.println("Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários");
        Map<String, Double> map = new HashMap<String, Double>();
        for (Funcionario funcionario : funcionarios) {
            map.put(funcionario.getFuncao(), funcionario.getSalario());
        }

        System.out.println();
        System.out.println();

        // 3.6 – Imprimir os funcionários, agrupados por função.
        System.out.println("Imprimir os funcionários, agrupados por função");
        Map<String, List<Funcionario>> groupedEmployees = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        for (Map.Entry<String, List<Funcionario>> entry : groupedEmployees.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        System.out.println();
        System.out.println();
        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("Imprimir os funcionários que fazem aniversário no mês 10 e 12.");
        double qtdSalarioMinimo = 0;
        for (Funcionario funcionario : funcionarios) {
            int mesAniversario = funcionario.getDataNascimento().getMonthValue();
            if (mesAniversario == 10) {
                System.out.println("Funcionário:" + funcionario.getNome() + " Faz aniversário no mes 10");
            }
            if (mesAniversario == 12 ) {
                System.out.println("Funcionário:" + funcionario.getNome() + " Faz aniversário no mes 12");
            }
        }

        System.out.println();
        System.out.println();

        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        System.out.println("Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.");
        Funcionario funcionarioMaisVelho = funcionarios.stream()
                .max(Comparator.comparingInt(Funcionario::getIdade)).orElse(null)
                ;

        // Imprime o funcionário com a maior idade
        if (funcionarioMaisVelho != null) {
            // Imprime o funcionário com a maior idade
            System.out.println("Funcionário com maior idade:");
            System.out.println("Nome: " + funcionarioMaisVelho.getNome());
            System.out.println("Idade: " + funcionarioMaisVelho.getIdade());
        } else {
            System.out.println("Não há funcionários na lista."); // Tratamento para lista vazia
        }


        System.out.println();
        System.out.println();


        //3.10 – Imprimir a lista de funcionários por ordem alfabética.
        System.out.println("Imprimir a lista de funcionários por ordem alfabética");
        Collections.sort(funcionarios, Comparator.comparing(Funcionario::getNome));
        System.out.println("Ordenado por nome");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }

        System.out.println();
        System.out.println();
        //3.11 – Imprimir o total dos salários dos funcionários.
        System.out.println("Imprimir o total dos salários dos funcionários. Neste cálculo estamos considerando o aumento");
        double totalSalario = 0;
        for (Funcionario funcionario : funcionarios) {
            totalSalario = funcionarios.stream().mapToDouble(Funcionario::getSalario).sum();
        }
        System.out.println("Total do salarios é :" +format.format(totalSalario) );

        System.out.println();
        System.out.println();

        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        double salarioMinimo = 1212;
        System.out.println("Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00");
        for (Funcionario funcionario : funcionarios) {
            qtdSalarioMinimo = Math.round(funcionario.getSalario() / salarioMinimo);
            System.out.println("funcionario " + funcionario.getNome() + " ganha " +  format("%.2f",qtdSalarioMinimo) + " salarios minimo");
        }
    }
}