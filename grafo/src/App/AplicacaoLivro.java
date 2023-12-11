package App;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Grafo.Grafo;

public class AplicacaoLivro {

	public static void menu() {
		System.out.println("Menu:\n"
				+ "Digite o código do comando: \n"
				+ "	1: Sugerir Livro \n"
				+ "	2: Registrar Dependência \n"
				+ "	3: Verificar ciclos de dependência \n"
				+ "	4: Mostrar ordem de leitura \n"
				+ "	5: Mostrar todos os livros cadastrados \n"
				+ "	999: Encerrar aplicação \n");
	}
	
	public static int pedeEntradaInt(Scanner sc) {
		int i = sc.nextInt();
		sc.nextLine(); // This line you have to add (it consumes the \n character)
	    return i;
	}
	
	public static String pedeEntradaString(Scanner sc) {
		String entrada;
        entrada = sc.nextLine();
	    return entrada;
	}
	
	public static int randomCode() {
		Random rand = new Random();
		int code = rand.nextInt(999);
		return code;
	}
	
	public static void main(String[] args) {
		//Cria o comparador de livros e o grafo
		ComparaLivrosNome<Livro> c = new ComparaLivrosNome<Livro>();
		Grafo<Livro> sugestoes = new Grafo<Livro>(c);
		
		//Cria um arraylist para armazenar os livros criados durante a execução
		ArrayList<Livro> livros = new ArrayList<Livro>();
		
		//Cria scanner para leitura
		Scanner sc = new Scanner(System.in).useDelimiter("\\s");
		int  entrada = 0;
		
		while(entrada!= 999) {
			//mostra o menu para o usuario
			menu();		
			
			//pede a entrada do usuário
			entrada = pedeEntradaInt(sc);
			
			//Avalia a entrada e realiza ações necessárias
			switch(entrada) {
			
				case 1://adicionar livro
					System.out.println("Digite o nome do livro\n");
					//pede o nome do livro
					String nome = pedeEntradaString(sc);
					Object aux;
					//cria o Livro
					Livro livro = new Livro(nome,randomCode());
					aux =  sugestoes.adicionarVertice(livro);
					if(aux == null) {
						System.out.println("Este livro já foi cadastrado\n");
					}
					else {
						livros.add(livro);
						System.out.println("O livro foi cadastrado com sucesso\n");
					}
					break;
					
				case 2: //adicionar dependência
					Livro destino = null;
					Livro origem = null;
					String nomeDestino;
					String nomeOrigem;
					
					System.out.println("digite o nome do livro que precisa de depedência\n");
					nomeDestino = pedeEntradaString(sc);
					
					System.out.println("digite o nome do livro que é a dependência\n");
					nomeOrigem = pedeEntradaString(sc);
					
					for(Livro l : livros) {
						if(l.getNome().equals(nomeDestino)) {
							destino = l;
						}
						else if (l.getNome().equals(nomeOrigem)) {
							origem = l;
						}
					}
					
					if(origem ==null || destino == null) {
						System.out.println("Um dos livros digitados não existe, verifique e tente novamente\n");
					}
					else {
						boolean aux2 = sugestoes.adicionarAresta(origem, destino);
						if (aux2 = false) {
							System.out.println("A dependência já existe e não foi adicionada\n");
						}
						else {
							System.out.println("A dependência foi cadastrada com sucesso\n");
						}
					}
					
					break;
				
				case 3: //Verificar ciclos
					if(sugestoes.temCiclo()) {
						System.out.println("Existem ciclos nas dependências entre os livros\n");
					}
					else {
						System.out.println("Não existem dependências, está tudo certo\n");
					}
					break;
					
				case 4: //Ordem de leitra
					ArrayList<Livro> ordem = sugestoes.ordenacaoTopologica();
					System.out.println(ordem.toString());
;					break;
					
				case 5: //Imprime livros
					sugestoes.printGrafo();
					break;
					
				case 999: //Encerra programa
					break;
					
				default: //Volta para o inicio
					break;				
			}
		}
		System.out.println("\n PROGRAMA ENCERRADO POR COMANDO DO USUÁRIO");
		sc.close(); 
	
	}
		
}
