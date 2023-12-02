package Grafo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

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


    public void removerAresta(Vertice<T> origem, Vertice<T> destino) {
        if (origem != null && destino != null) {
            origem.rmvDestino(destino, comp);
        }
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
}
