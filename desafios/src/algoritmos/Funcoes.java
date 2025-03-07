package algoritmos;

public class Funcoes	{
	public static int fatorial (int numero)	{
		if (numero == 0 ^ numero == 1)	{
			return 1;
		}	else	{
			int resultado = 2;
			for (int operando = 3; operando <= numero; operando++)	{
				resultado *= operando;
			}
			return resultado;
		}
	}
	public static void fizzBuzz ()	{
		int variavel = 1;
		String palavras;
		while (variavel <= 100)	{
			palavras = "";
			
			if (variavel % 3 == 0)	{
				palavras += "Fizz";
			}
			if (variavel % 5 == 0)	{
				palavras += "Buzz";
			}
			
			if (! (palavras.equals("")))	{
				System.out.println(palavras);
			}	else	{
				System.out.println(variavel);
			}

			variavel++;
		}
	}
	public static boolean palindromo (String palavra)	{
        boolean verificador = true;
        char [] vetor = palavra.toUpperCase().toCharArray();

        for (int esquerda = 0, direita = vetor.length - 1, limite = direita / 2;
			esquerda < limite && direita > limite && verificador;
			esquerda++, direita--)   {

            if (vetor[esquerda] != vetor[direita])  {
                verificador = false;
            }
        }

        return verificador;
	}
	private static void merge (int vetor [], int esq, int meio, int dir)	{
		int tamEsq = meio - esq + 1;
		int tamDir = dir - meio;

		int [] tempEsq = new int [tamEsq];
		int [] tempDir = new int [tamDir];

		for (int aux = 0; aux < tamEsq; aux++)	{
			tempEsq[aux] = vetor[esq + aux];
		}
		for (int aux = 0; aux < tamDir; aux++)	{
			tempDir[aux] = vetor[meio + aux + 1];
		}

		int i = 0;
		int j = 0;
		int k = esq;

		while (i < tamEsq && j < tamDir)	{
			if (tempEsq[i] <= tempDir[j])	{
				vetor[k] = tempEsq[i];
				i++;
			}	else	{
				vetor[k] = tempDir[j];
				j++;
			}
			k++;
		}

		while (i < tamEsq)	{
			vetor[k] = tempEsq[i];
			i++;
			k++;
		}

		while (j < tamDir)	{
			vetor[k] = tempDir[j];
			j++;
			k++;
		}
	}
	private static void sort (int vetor [], int esq, int dir)	{
		if (esq < dir)	{
			int meio = esq + (dir - esq) / 2;

			sort(vetor, esq, meio);
			sort(vetor, meio + 1, dir);

			merge(vetor, esq, meio, dir);
		}
	}
	public static boolean [] verificaPrimos (int vetor [])	{
		sort(vetor, 0, vetor.length - 1);

		int contador = 0;
		int divisor = 3;
		boolean resultado [] = new boolean [vetor.length];

		while (contador < resultado.length)	{
			resultado[contador++] = true;
		}

		contador = 0;

		while (contador < resultado.length)	{
			if (vetor[contador] % 2 == 0)	{
				resultado[contador] = false;
			}	else	{
				while (divisor < vetor[contador] && resultado[contador])	{
					if (vetor[contador] % divisor == 0)	{
						resultado[contador] = false;
					}	else	{
						divisor += 2;
					}
				}
			}
			contador++;
		}

		return resultado;
	}
}
