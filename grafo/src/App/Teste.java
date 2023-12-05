package App;
import java.util.ArrayList;

import Grafo.Grafo;
import Grafo.Vertice;


public class Teste {

	public static void main(String[] args) {
		ComparaDisciplinasNome<Disciplina> c = new ComparaDisciplinasNome<Disciplina>();
		Grafo<Disciplina> teste = new Grafo<Disciplina>(c);
		ArrayList<Vertice<Disciplina>> ordenacaoTOP = new ArrayList<>();
		
		Disciplina d1 = new Disciplina("logica", 001, 1);
		Disciplina d2 = new Disciplina("programacao", 002, 1);
		Disciplina d3 = new Disciplina("comunicacao", 003, 1);
		Disciplina d4 = new Disciplina("estrutura de dados", 004, 1);
		
		teste.adicionarVertice(d1);
		teste.adicionarVertice(d2);
		teste.adicionarVertice(d3);
		teste.adicionarVertice(d4);
		
		System.out.println(teste.toString());
		
		//teste.adicionarAresta(d1, d2);
		//teste.adicionarAresta(d1, d2);
		teste.adicionarAresta(d2, d3);
		teste.adicionarAresta(d3, d4);
		teste.adicionarAresta(d4, d3);
		teste.adicionarAresta(d3, d2);
		
		teste.printArestas();
		
		ordenacaoTOP = teste.ordenacaoTopologica();	
		System.out.println(ordenacaoTOP.toString());
	}

}
