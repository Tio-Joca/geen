package principal;

import algoritmos.Funcoes;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner entrada;
        int opcao;

        do  {
            System.out.print("Qual operacao voce deseja fazer?"
            + "\n0) Encerrar o programa"
            + "\n1) Fatorial"
            + "\n2) FizzBuzz"
            + "\n3) Ordenação de vetor e verificação de números primos no vetor"
            + "\n4) Verificação de palíndromo"
            + "\nInsira a sua opção aqui: ");

            entrada = new Scanner (System.in);
            opcao = entrada.nextInt();

            switch (opcao)  {
                case 0:
                    System.out.println("Programa encerrado.");
                    entrada.close();
                    break;
                case 1:
                    controleFatorial(entrada);
                    break;
                case 2:
                    controleFizzBuzz();
                    break;
                case 3:
                    controlePrimos(entrada);
                    break;
                case 4:
                    controlePalindromo(entrada);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }   while (opcao != 0);
    }
    public static void controleFatorial (Scanner entrada)  {
        int valor;

        entrada.nextLine();

        do  {
            System.out.print("Qual numero inteiro maior que 0 você deseja utilizar para a operação? ");
            valor = entrada.nextInt();

            if (valor < 0)  {
                System.out.println("Não é possível obter o fatorial do número informado (valor inteiro abaixo de zero)!");
            }   else    {
                System.out.println("O fatorial de " + valor + " é " + Funcoes.fatorial(valor));
            }
        }   while (valor < 0);        
    }
    public static void controleFizzBuzz ()  {
        String [] palavras = Funcoes.fizzBuzz();

        for (int aux = 0; aux < palavras.length; aux++) {
            System.out.println(palavras[aux]);
        }
    }
    public static void controlePrimos (Scanner entrada)    {
        int [] vetor = new int [10];
        boolean [] primos;

        entrada.nextLine();

        for (int x = 0; x < vetor.length; x++)  {
            System.out.print("Digite um numero inteiro para ser armazenado na posição " + x + " do vetor: ");
            vetor[x] = entrada.nextInt();
        }

        for (int x = 0; x < vetor.length; x++)   {
            if (x == 0) {
                System.out.print("Vetor em seu estado inicial: [" + vetor[x] + ", ");
            }   else if (x == vetor.length - 1) {
                System.out.println(vetor[x] + "]");
            }   else    {
                System.out.print(vetor[x] + ", ");
            }
        }

        Funcoes.sort(vetor, 0, vetor.length - 1);

        for (int x = 0; x < vetor.length; x++)   {
            if (x == 0) {
                System.out.print("Vetor ordenado: [" + vetor[x] + ", ");
            }   else if (x == vetor.length - 1) {
                System.out.println(vetor[x] + "]");
            }   else    {
                System.out.print(vetor[x] + ", ");
            }
        }

        primos = Funcoes.verificaPrimos(vetor);

        for (int x = 0; x < primos.length; x++)  {
            if (x == 0) {
                System.out.print("Os números primos presentes no vetor estão nos índices: ");
            }

            if (primos[x])  {
                if (x < primos.length - 1)  {
                    System.out.print(x + ", ");
                }   else    {
                    System.out.println(x);
                }
            }
        }
    }
    public static void controlePalindromo (Scanner entrada) {
        String cadeia;
        boolean palindromo;

        entrada.nextLine();

        do  {
            System.out.print("Qual cadeia de caracteres voce deseja verificar? ");
            cadeia = entrada.nextLine();

            if (cadeia.equals(""))  {
                System.out.println("Não é possível fazer essa operação com uma cadeia de caracteres vazia!");
            }   else    {
                palindromo = Funcoes.palindromo(cadeia);

                if (palindromo) {
                    System.out.println("A cadeia de caracteres " + cadeia + " é um palíndromo.");
                }   else    {
                    System.out.println("A cadeia de caracteres " + cadeia + " não é um palíndromo.");
                }
            }
        }   while (cadeia.equals(""));
    }
}
