package principal;

import algoritmos.Funcoes;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner entrada;
        int opcao;
        String saida = null;

        do  {
            System.out.print("Qual operação você deseja fazer?\n"
            + "\n0) Encerrar o programa"
            + "\n1) Fatorial"
            + "\n2) FizzBuzz"
            + "\n3) Ordenação de vetor e verificação de números primos no vetor"
            + "\n4) Verificação de palíndromo\n"
            + "\nInsira a sua opção aqui: ");

            entrada = new Scanner (System.in);
            opcao = entrada.nextInt();

            switch (opcao)  {
                case 0:
                    System.out.println("\nPrograma encerrado.");
                    entrada.close();
                    break;
                case 1:
                    controleFatorial(entrada);
                    break;
                case 2:
                    controleFizzBuzz(saida);
                    break;
                case 3:
                    controlePrimos(entrada, saida);
                    break;
                case 4:
                    controlePalindromo(entrada);
                    break;
                default:
                    System.out.println("\nOpção inválida!\n");
                    break;
            }
        }   while (opcao != 0);
    }
    public static void controleFatorial (Scanner entrada)  {
        int valor;

        entrada.nextLine();

        do  {
            System.out.print("\nQual número inteiro maior que 0 você deseja utilizar para a operação? ");
            valor = entrada.nextInt();

            if (valor < 0)  {
                System.out.println("Não é possível obter o fatorial do número informado (valor inteiro abaixo de zero)!");
            }   else    {
                System.out.println("O fatorial de " + valor + " é " + Funcoes.fatorial(valor) + "\n");
            }
        }   while (valor < 0);        
    }
    public static void controleFizzBuzz (String saida)  {
        String [] palavras = Funcoes.fizzBuzz();

        saida = "\nResultado da operação Fizz Buzz:\n";

        for (int aux = 0; aux < palavras.length; aux++) {
            saida += palavras[aux];

            if ((aux + 1) % 10 == 0)  {
                saida += "\n";
            }   else    {
                saida += ", ";
            }
        }

        System.out.println(saida);

        saida = null;
    }
    public static void controlePrimos (Scanner entrada, String saida)    {
        int [] vetor = new int [10];
        boolean [] primos;
        boolean existe = false;

        entrada.nextLine();

        for (int x = 0; x < vetor.length; x++)  {
            if (x == 0) {
                System.out.print("\nDigite um numero inteiro para ser armazenado na posição " + x + " do vetor: ");
            }   else    {
                System.out.print("Digite um numero inteiro para ser armazenado na posição " + x + " do vetor: ");
            }
            vetor[x] = entrada.nextInt();
        }

        saida = "";

        for (int x = 0; x < vetor.length; x++)   {
            if (x == 0) {
                saida += "Vetor em seu estado inicial: [" + vetor[x] + ", ";
            }   else if (x == vetor.length - 1) {
                saida += vetor[x] + "]";
            }   else    {
                saida += vetor[x] + ", ";
            }
        }

        System.out.println("\n" + saida);
        saida = null;

        Funcoes.sort(vetor, 0, vetor.length - 1);

        saida = "";

        for (int x = 0; x < vetor.length; x++)   {
            if (x == 0) {
                saida += "Vetor ordenado: [" + vetor[x] + ", ";
            }   else if (x == vetor.length - 1) {
                saida += vetor[x] + "]";
            }   else    {
                saida += vetor[x] + ", ";
            }
        }

        System.out.println(saida);
        saida = null;

        primos = Funcoes.verificaPrimos(vetor);

        saida = "";

        for (int x = 0; x < primos.length; x++)  {
            if (primos[x])  {
                if (! existe)   {
                    saida += "[" + x;
                    existe = true;
                }   else    {
                    saida += ", " + x;
                }
            }
        }

        if (existe) {
            saida += "]";
        }   else    {
            saida = null;
        }

        if (saida != null)  {
            System.out.println("Os números primos presentes no vetor estão nos índices: " + saida + "\n");
        }   else    {
            System.out.println("Não há números primos no vetor!\n");
        }
    }
    public static void controlePalindromo (Scanner entrada) {
        String cadeia;
        boolean palindromo;

        entrada.nextLine();

        do  {
            System.out.print("\nQual cadeia de caracteres voce deseja verificar? ");
            cadeia = entrada.nextLine();

            if (cadeia.equals(""))  {
                System.out.println("Não é possível fazer essa operação com uma cadeia de caracteres vazia!");
            }   else    {
                palindromo = Funcoes.palindromo(cadeia);

                if (palindromo) {
                    System.out.println("A cadeia de caracteres " + cadeia + " é um palíndromo.\n");
                }   else    {
                    System.out.println("A cadeia de caracteres " + cadeia + " não é um palíndromo.\n");
                }
            }
        }   while (cadeia.equals(""));
    }
}
