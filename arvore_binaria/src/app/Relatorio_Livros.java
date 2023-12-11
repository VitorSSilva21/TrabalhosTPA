package app;

import java.util.Comparator;
import java.util.Scanner;
import lib.ArvoreBinaria;
import lib.No;

public class Relatorio_Livros{
    public static void main(String[] args) {
        // Criando uma instância da árvore binária de livros
        ArvoreBinaria<Livro> arvoreLivros = new ArvoreBinaria<>(Comparator.comparing(Livro::getTitulo));

        // Criando um scanner para interação com o usuário
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 999) {
            System.out.println("\n----- Menu Principal -----");
            System.out.println("1. Cadastrar um livro");
            System.out.println("2. Consultar dados de um livro");
            System.out.println("3. Excluir um livro");
            System.out.println("4. Exibir todos os livros");
            System.out.println("999. Sair\n");

            System.out.print("Escolha uma opção: ");
            try{
            	opcao = scanner.nextInt();
            }
            catch(Exception e){
            	System.out.println("Opção inválida, tente novamente\n");
            	opcao = 0;
            }
            
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarLivro(scanner, arvoreLivros);
                    break;
                case 2:
                    consultarLivro(scanner, arvoreLivros);
                    break;
                case 3:
                    excluirLivro(scanner, arvoreLivros);
                    break;
                case 4:
                    exibirTodosLivros(arvoreLivros);
                    break;
                case 999:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    private static void cadastrarLivro(Scanner scanner, ArvoreBinaria<Livro> arvoreLivros) {
        System.out.println("\n----- Cadastro de Livro -----");

        System.out.print("Título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor do livro: ");
        String autor = scanner.nextLine();

        Livro novoLivro = new Livro(titulo, autor);
        arvoreLivros.adicionar(novoLivro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void consultarLivro(Scanner scanner, ArvoreBinaria<Livro> arvoreLivros) {
        System.out.println("\n----- Consulta de Livro -----");

        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        Livro livroConsultado = arvoreLivros.pesquisar(new Livro(titulo, ""));

        if (livroConsultado != null) {
            System.out.println("Livro encontrado:");
            System.out.println("Título: " + livroConsultado.getTitulo());
            System.out.println("Autor: " + livroConsultado.getAutor());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private static void excluirLivro(Scanner scanner, ArvoreBinaria<Livro> arvoreLivros) {
        System.out.println("\n----- Exclusão de Livro -----");

        System.out.print("Digite o título do livro a ser excluído: ");
        String titulo = scanner.nextLine();

        Livro livroParaExcluir = new Livro(titulo, "");
        Livro livroExcluido = arvoreLivros.remover(livroParaExcluir);

        if (livroExcluido != null) {
            System.out.println("Livro excluído com sucesso:");
            System.out.println("Título: " + livroExcluido.getTitulo());
            System.out.println("Autor: " + livroExcluido.getAutor());
        } else {
            System.out.println("Livro não encontrado. Nenhum livro foi excluído.");
        }
    }

    private static void exibirTodosLivros(ArvoreBinaria<Livro> arvoreLivros) {
        System.out.println("\n----- Lista de Livros -----");
        Scanner S = new Scanner(System.in);

        // Obtendo a quantidade de livros na árvore
        int quantidadeLivros = arvoreLivros.quantidadeNos();

        if (quantidadeLivros == 0) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        // Obtendo a altura da árvore para calcular o número de páginas
        int alturaArvore = arvoreLivros.altura();
        int paginas = (int) Math.ceil((double) quantidadeLivros / 10);

        for (int pagina = 0; pagina < paginas; pagina++) {
            System.out.println("\n--- Página " + (pagina + 1) + " ---");

            // Calculando os índices inicial e final para a página atual
            int indiceInicial = pagina * 10;
            int indiceFinal = Math.min((pagina + 1) * 10, quantidadeLivros);

            // Exibindo os livros da página atual
            for (int i = indiceInicial; i < indiceFinal; i++) {
                Livro livro = obterLivroPorIndice(arvoreLivros, i);
                System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
            }

            // Pausa após exibir cada página
            System.out.print("Pressione Enter para continuar...");
            S.nextLine();
        }
    }
    
    private static Livro obterLivroPorIndiceRecursivo(No<Livro> no, int[] contador, int indiceAlvo) {
        if (no == null) {
            return null;
        }

        // Traversa à esquerda
        Livro livroEncontrado = obterLivroPorIndiceRecursivo(no.getFilho_esquerda(), contador, indiceAlvo);

        // Processa o nó atual
        if (livroEncontrado == null) {
            if (contador[0] == indiceAlvo) {
                livroEncontrado = no.getChave();
            }
            contador[0]++;
        }

        // Traversa à direita
        if (livroEncontrado == null) {
            livroEncontrado = obterLivroPorIndiceRecursivo(no.getFilho_direita(), contador, indiceAlvo);
        }

        return livroEncontrado;
    }

    private static Livro obterLivroPorIndice(ArvoreBinaria<Livro> arvoreLivros, int indice) {
        int[] contador = {0}; // Usando um array para armazenar o contador como uma variável mutável

        return obterLivroPorIndiceRecursivo(arvoreLivros.getRaiz(), contador, indice);
    }
    
   
}
