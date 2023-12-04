package Grafo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Grafo<T> {
    private ArrayList<Vertice<T>> vertices;
    private Comparator<T> comp;
    
    public Grafo(Comparator<T> c) {
    	this.comp = c;
    }
    
    //Outros membros da classe, como vértices e arestas
    public void adicionarAresta(T origem, T destino) {
    	Vertice<T> tori; 
    	Vertice<T> tdest;
    	tori = this.obterVertice(origem);
    	tdest = this.obterVertice(destino);
        tori.addDestino(tdest, comp);
    }

    public Vertice<T> adicionarVertice(T valor) {
    	if(this.vertices == null) {
    		this.vertices = new ArrayList<>();
    		Vertice<T> novo = new Vertice<>(valor);
            this.vertices.add(novo);
            return novo;
    	}
    	else if(this.obterVertice(valor)==null) {
    		Vertice<T> novo = new Vertice<>(valor);
            this.vertices.add(novo);
            return novo;
    	}
    	else{
    		return null;
    	}
        
    }
    
    public Vertice<T> removerVertice(T valor){
    	Vertice<T> v;
        v = new Vertice<>(valor);
    	if(this.vertices == null) {
    		return null;
    	}
    	else if(this.obterVertice(valor)==null) {
    		return null;
    	}
    	else{
    		for (int i = 0; i < this.vertices.size(); i++) {
                if (comp.compare(v.getValor(), this.vertices.get(i).getValor())==0) {
                	return this.vertices.remove(i);
                }
            }
    	}
    	return null;
    }


    public void removerAresta(Vertice<T> origem, Vertice<T> destino) {
        if (origem != null && destino != null) {
            origem.rmvDestino(destino, comp);
        }
    }

    private Vertice<T> obterVertice(T valor) {
        Vertice<T> v;
        v = new Vertice<>(valor);
        for (int i = 0; i < this.vertices.size(); i++) {
            if (comp.compare(v.getValor(), this.vertices.get(i).getValor())==0) {
                return v;
            }
        }
        // Se chegou aqui é porque não existe um vértice com esse valor
        return null;
    }

	@Override 
	public String toString(){
		String saida ="";
		for (int i = 0; i < this.vertices.size(); i++) {
			saida += "" + this.vertices.get(i).toString() + "\n";
	    }
		return saida;
	}

	public boolean temCiclo() {
        Set<Vertice<T>> visitados = new HashSet<>();
        Set<Vertice<T>> pilhaRecursao = new HashSet<>();

        for (Vertice<T> vertice : vertices) {
            if (!visitados.contains(vertice)) {
                if (temCicloRecursivo(vertice, visitados, pilhaRecursao)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean temCicloRecursivo(Vertice<T> vertice, Set<Vertice<T>> visitados, Set<Vertice<T>> pilhaRecursao) {
        visitados.add(vertice);
        pilhaRecursao.add(vertice);

        for (Vertice<T> destino : vertice.getDestinos()) {
            if (!visitados.contains(destino)) {
                if (temCicloRecursivo(destino, visitados, pilhaRecursao)) {
                    return true;
                }
            } else if (pilhaRecursao.contains(destino)) {
                return true;
            }
        }

        pilhaRecursao.remove(vertice);
        return false;
    }

    private void ordenacaoTopologicaAuxiliar(Vertice<T> vert, Stack<T> pilha, Stack<T> pilhaOrdenada){
    	pilha.push(vert); //Empilha o vertice na pilha
    	vert.setVisitado(true); //Marca o vértice atual como visitado;
	
        if (!vert.getDestinos().isEmpty()){ //Verifica se o ArrayList de destinos está vazio
            for(Vertice<T> ve : vert.getDestinos()) { //Se não estiver, percorre-o para visitar os vertices de destino
                ordenacaoTopologicaAuxiliar(ve, pilha);
            }
        }
        pilhaOrdenada.push(pilha.pop());
    }

    public ArrayList<Vertice<T>> ordenacaoTopologica(){
    	ArrayList<Vertice<T>> ordenadosTOP = new ArrayList<>();
        Vertice<T> vertice = this.vertices.get(0);
        Stack<T> pilha = new Stack<T>();
        Stack<T> pilhaOrdenada = new Stack<T>();
        Vertice<T> aux = new Vertice<>();

        for(Vertice<T> v : this.vertices){
            v.setVisitado(false); //Coloca todos os vértices como não visitados
        }

        if (!v.isVisitado()){
           ordenacaoTopologicaAuxiliar(vertice, pilha, pilhaOrdenada);
        }
	    
        System.out.print("Ordenação Topológica: ");
        // Coloca os vertices da pilha no ArrayList de retorno e Imprime o conteúdo da pilha na ordem topológica
        while (!pilhaOrdenada.empty()) {
            aux = pilhaOrdenada.pop();
            ordenadosTOP.add(aux);
            System.out.print(aux.toString());
        }
        System.out.println("\n");
        
        return ordenadosTOP;
    }
}
