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
    public boolean adicionarAresta(T origem, T destino) {
    	Vertice<T> tori; 
    	Vertice<T> tdest;
    	tori = this.obterVertice(origem);
    	tdest = this.obterVertice(destino);
    	boolean adicionado = tori.addDestino(tdest, comp);
    	boolean temciclo = this.temCiclo();
    	if (temciclo) {
    		this.removerAresta(tori, tdest);
    		return false;
    	}
    	else {
    		return adicionado;
    	}
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
        for (int i=0; i<this.vertices.size(); i++) {
            if (comp.compare(valor, this.vertices.get(i).getValor())==0) {
                return vertices.get(i);
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

        for (Vertice<T> vertice : this.vertices) {
            //System.out.println(vertice);
            if (!(visitados.contains(vertice))) {
            	visitados.add(vertice);
            	for (Vertice<T> vizinho : vertice.getDestinos()) {
            	   //System.out.println(vizinho);
            	   if (visitados.contains(vizinho)) {
            		return true;
            	   }
            	}
            }
            else return true;
        }
        return false;
    }

    private void ordenacaoTopologicaAuxiliar(Vertice<T> vert, Stack<Vertice<T>> pilha, Stack<Vertice<T>> pilhaOrdenada){
    	pilha.push(vert); //Empilha o vertice na pilha
    	vert.setVisitado(true); //Marca o vértice atual como visitado;
	
        if (!vert.getDestinos().isEmpty()){ //Verifica se o ArrayList de destinos está vazio
            for(Vertice<T> ve : vert.getDestinos()) { //Se não estiver, percorre-o para visitar os vertices de destino
                ordenacaoTopologicaAuxiliar(ve, pilha,pilhaOrdenada);
            }
        }
        pilhaOrdenada.push(pilha.pop()); //Empilha na pilhaOrdenada o vértice que já foi visitado e não possui vértice adjacente
    }

    public ArrayList<Vertice<T>> ordenacaoTopologica(){
    	//Vertice<T> indice = this.obterVertice(inicio);
    	ArrayList<Vertice<T>> ordenadosTOP = new ArrayList<>();
        //Vertice<T> vertice = this.vertices.get(0);
        Stack<Vertice<T>> pilha = new Stack<Vertice<T>>();
        Stack<Vertice<T>> pilhaOrdenada = new Stack<Vertice<T>>();

        for(Vertice<T> v : this.vertices){
            v.setVisitado(false); //Coloca todos os vértices como não visitados
	        
        }
        for(Vertice<T> p : this.vertices){
        	if (!p.isVisitado()){
 	           ordenacaoTopologicaAuxiliar(p, pilha, pilhaOrdenada);
        	}
        }
        
        
        System.out.print("Ordenação Topológica: ");
        // Coloca os vertices da pilha no ArrayList de retorno e Imprime o conteúdo da pilha na ordem topológica
        while (!pilhaOrdenada.empty()) {
            ordenadosTOP.add(pilhaOrdenada.pop()); //Coloca na lista de ordenados o topo da pilha
        }
        return ordenadosTOP; //Retorna o ArrayList ordenado topologicamente
    }
    
    public void printArestas() {
    	for(int i=0;i<vertices.size();i++) {
    		ArrayList<Vertice<T>> aux = vertices.get(i).getDestinos();
    		for(int p=0;p<(aux.size());p++) {
    			System.out.println(vertices.get(i) + " " + aux.get(p).toString());
    		}
    	}
    }
    
}
