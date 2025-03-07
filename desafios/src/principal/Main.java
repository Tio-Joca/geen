package principal;

import algoritmos.Funcoes;

public class Main {
    public static void main (String[] args) {
        System.out.println(Funcoes.fatorial(6));
        Funcoes.fizzBuzz();
        System.out.println(Funcoes.palindromo("sopapos"));
        int [] teste = {10, 3, 34, -2, 43};
        boolean [] primos = Funcoes.verificaPrimos(teste);
        for (int aux = 0; aux < primos.length; aux++)    {
            if (primos[aux])    {
                System.out.println(aux);
            }
        }
    }
}
