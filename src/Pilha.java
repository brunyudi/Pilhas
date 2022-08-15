/**
 * Aluno: Bruno Yudi Mino Okada
 *
 * Sua  tarefa  será  construir  um  código  capaz de  somar,  item  a  item,  todos os  inteiros  entre  1  e
 * 1.000.000. Existe, pelo menos uma fórmula matemática que pode ser usada para validar o resultado.
 * Contudo,  você  deverá  criar  uma  pilha,  armazenar  este  inteiros  nesta  pilha,  depois  percorrer    pilha
 * somando estes valores. A tarefa é para exercitar o uso de pilhas, não da matemática.
 * Seu  objetivo  será  medir  o  tempo  para  inserção  de  1.000.000  milhão  de  inteiros  em  uma
 * estrutura  de  dados  e  o  tempo  para  percorrer  e  somar  1.000.000  de  inteiros  em  uma  determinada
 * estrutura de dados, e o tempo para garantir que um determinado inteiro já está na pilha. Finalmente
 * você deverá medir estes tempos percorrendo a pilha em dois sentidos. De cima para baixo e de baixo
 * para cima.
 * Seu resultado será a média dos tempos gastos para as operações citadas acima em, no mímino
 * 50 operações de cada tipo. As saídas apresentadas devem seguir o seguinte padrão: operação: tempo
 * conforme pode ser visto no exemplo a seguir:
 * Preenchimento da Pilha: 1.234s
 * Programas cuja saída tenham linhas que não sejam relativas as operações realizadas ou que não
 * apresentem a formatação correta sofrerão um demérito na nota.
 * Para resolver esta tarefa você poderá usar as linguagens Python, Java, C ou C++ de acordo com
 * a  sua  preferência.  A  tarefa  deverá  ser  entregue  no  ambiente  virtual  de  aprendizagem  conforme  as
 * instruções constante neste documento.
 * Lembre-se: uma estrutura de dados consiste em uma definição de estrutura de memória, e dos
 * métodos,  ou  funções  para  trabalhar  com  esta  estrutura.  No  mínimo  teremos  que  ter  métodos  para
 * escrever, ler, remover e buscar valores na pilha. Programas que realizem as tarefas necessárias sem a
 * definição da estrutura de dados serão zerados.
 */

import java.util.Random;
import java.util.Stack;

public class Pilha {
    public static void main(String[] args) {
        //Criação de uma pilha para armazenar os 1.000.000 elementos
        Stack pilha = new Stack();
        //Criação de um gerador de números aleatórios para buscar na lista
        Random geradorAleatorio = new Random();
        int somatorio = 0;

        //Operações para incluir os 1.000.000 elementos na pilha e calcular o tempo que demorou
        long tempoInicialDeInsercao = System.currentTimeMillis();
        for(int i = 0; i <= 1000000; i++){
            pilha.push(i);
        }
        long tempoFinalDeInsercao = System.currentTimeMillis();
        long tempoDeInsercao = tempoFinalDeInsercao - tempoInicialDeInsercao;
        System.out.println("Tempo de preenchimento da pilha: " + tempoDeInsercao + "ms");
        System.out.println("Tempo medio de insercao de cada elemento: " + tempoDeInsercao/pilha.size() + "ms");

        //Criação de um clone da pilha com 1.000.000 elementos
        Stack pilha50Elementos = new Stack();
        Stack clonePilha = (Stack)pilha.clone();

        //Operações para somar cada um dos 1.000.000 elementos da pilha e medir o tempo
        long tempoInicialDeSomatoria = System.currentTimeMillis();
        for(int i = 0; i <= 1000000; i++){
            int numeroParaSomar = (int)pilha.pop();
            somatorio += numeroParaSomar;
        }
        long tempoFinalDeSomatoria = System.currentTimeMillis();
        long tempoDeSomatoria = tempoFinalDeSomatoria - tempoInicialDeSomatoria;
        System.out.println("Tempo de somatoria de todos os 1.000.000 elementos: " + tempoDeSomatoria + "ms");
        System.out.println("Tempo medio de somatoria de cada elemento: " + tempoDeSomatoria/1000000 + "ms");
        System.out.println("Somatoria dos 1.000.000 elementos da pilha: " + somatorio);

        //Operações para verificar se o numero aleatório gerado está na pilha e medir o tempo da operação
        long tempoInicialDeProcura = System.currentTimeMillis();
        for(int i=1; i<=50; i++){
            //gera um numero inteiro aleatório entre 0 e 1.000.000
            int x = geradorAleatorio.nextInt(1000001);
            //verifica se o numero está na pilha
            int posicaoNumero = clonePilha.search(x);
            if(posicaoNumero == 0){
                System.out.println("O numero nao esta na pilha!");
            }
            int numero = (int)clonePilha.get(Math.abs(1000000-posicaoNumero));
            pilha50Elementos.push(numero);
        }
        long tempoFinalDeProcura = System.currentTimeMillis();
        long tempoDeProcura = tempoFinalDeProcura - tempoInicialDeProcura;
        System.out.println("Tempo de procura de 50 elementos aleatorios na lista: " + tempoDeProcura + "ms");
        System.out.println("Tempo medio de procura de cada elemento: " + tempoDeProcura/pilha50Elementos.size() + "ms");

        //Realiza o somatorio dos 50 elementos aleatorios e mede o tempo que demorou
        long tempoInicialSoma50Elementos = System.currentTimeMillis();
        int soma50Elementos = 0;
        for(int i=1; i<= pilha50Elementos.size(); i++){
            int numeroSoma = (int)pilha50Elementos.pop();
            soma50Elementos += numeroSoma;
        }
        long tempoFinalSoma50Elementos = System.currentTimeMillis();
        long tempoSoma50Elementos = tempoFinalSoma50Elementos - tempoInicialSoma50Elementos;
        System.out.println("Tempo de soma dos 50 elementos aleatorios: " + tempoSoma50Elementos + "ms");
        System.out.println("Tempo medio de soma de cada elemento: " + tempoSoma50Elementos/50 + "ms");
        System.out.println("Soma dos 50 elementos aleatorios: " + soma50Elementos);

        //Apenas percorre a pilha de baixo para cima e mede o tempo que demorou
        long tempoInicialPercursoBaixoCima = System.currentTimeMillis();
        for (int i = 1; i<= clonePilha.size(); i++){
        }
        long tempoFinalPercursoBaixoCima = System.currentTimeMillis();
        long tempoPercursoBaixoCima = tempoFinalPercursoBaixoCima - tempoInicialPercursoBaixoCima;
        System.out.println("Tempo de percurso da pilha de baixo para cima: " + tempoPercursoBaixoCima + "ms");

        //Apenas percorre a pilha de cima para baixo e mede o tempo que demorou
        long tempoInicialPercursoCimaBaixo = System.currentTimeMillis();
        for (int i = clonePilha.size(); i >= 0; i--){
        }
        long tempoFinalPercursoCimaBaixo = System.currentTimeMillis();
        long tempoPercursoCimaBaixo = tempoFinalPercursoCimaBaixo - tempoInicialPercursoCimaBaixo;
        System.out.println("Tempo de percurso da pilha de cima para baixo: " + tempoPercursoCimaBaixo + "ms");
    }
}
