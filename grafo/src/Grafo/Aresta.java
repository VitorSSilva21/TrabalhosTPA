package Grafo;
public class Aresta<T> {
    private Vertice<T> origem, destino;
    public Aresta(Vertice<T> origem, Vertice<T> destino){
    	this.origem = origem;
    	this.destino = destino;
    }
    void setOrigem(Vertice<T> origem){
    	this.origem = origem;
    }
    void setDestino(Vertice<T> destino) {
    	this.destino = destino;
    }
    Vertice<T> getOrigem(){
    	return this.origem;
    }
    Vertice<T> getDestino(){
    	return this.destino;
    }
}
