package App;
import Grafo.Grafo;


public class Teste {

	public static void main(String[] args) {
		ComparaDisciplinasNome<Disciplina> c = new ComparaDisciplinasNome<Disciplina>();
		Grafo<Disciplina> teste = new Grafo<Disciplina>(c);
		ArrayList<Vertice<T>> ordenacaoTOP = new ArrayList<>();
		Disciplina d1 = new Disciplina("logica", 001, 1);
		Disciplina d2 = new Disciplina("programacao", 002, 1);
		Disciplina d3 = new Disciplina("comunicacao", 003, 1);
		Disciplina d4 = new Disciplina("logica", 004, 1);
		teste.adicionarVertice(d1);
		teste.adicionarVertice(d2);
		teste.adicionarVertice(d3);
		teste.adicionarVertice(d4);
		System.out.println(teste.toString());
		teste.adicionarAresta(d1, d2);
		ordenacaoTOP = teste.ordenacaoTopologica();	
	}

}
