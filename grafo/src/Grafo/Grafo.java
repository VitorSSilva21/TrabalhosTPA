package Grafo;
import java.util.ArrayList;
import java.util.Comparator;

public class Grafo<T> {
    private ArrayList<Vertice<T>> vertices;
    private Comparator<T> comp;
    
    public Grafo(Comparator<T> c) {
    	this.comp = c;
    }
    
    //Outros membros da classe, como vértices e arestas
    public void adicionarAresta(Vertice<T> origem, Vertice<T> destino) {
        origem.addDestino(destino, comp);
    }

    public Vertice<T> adicionarVertice(T valor) {
    	if(this.vertices == null) {
    		this.vertices = new ArrayList<Vertice<T>>();
    		Vertice<T> novo = new Vertice<T>(valor);
            this.vertices.add(novo);
            return novo;
    	}
    	else if(this.obterVertice(valor)==null) {
    		Vertice<T> novo = new Vertice<T>(valor);
            this.vertices.add(novo);
            return novo;
    	}
    	else{
    		return null;
    	}
        
    }
    
    public Vertice<T> removerVertice(T valor){
    	Vertice<T> v;
        v = new Vertice<T>(valor);
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

    private Vertice<T> obterVertice(T valor) {
        Vertice<T> v;
        v = new Vertice<T>(valor);
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
}
