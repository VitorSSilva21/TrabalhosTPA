package Grafo;
import java.util.ArrayList;
import java.util.Comparator;

public class Vertice <T> {
	private T valor;
    private ArrayList<Vertice<T>> destinos;
	private boolean visitado;
    
    public Vertice(T valor){
    	this.valor= valor;
		this.destinos = new ArrayList<>();
		this.visitado = false;
    }
    
    public void addDestino(Vertice<T> dest,Comparator<T> c) {
    	for(int i=0;i<destinos.size();i++) {
    		if(c.compare(dest.getValor(), destinos.get(i).getValor())==0){
    			return;
    		}
    	}
    	this.destinos.add(dest);
    	return;    	
    }
    
    public Vertice<T> rmvDestino (Vertice<T> dest, Comparator<T> c) {
    	for(int i=0;i<destinos.size();i++) {
    		if(c.compare(dest.getValor(), destinos.get(i).getValor())==0){
    			return this.destinos.remove(i);
    		}
    	}
    	return null;
    }
    
    public T getValor() {
    	return this.valor;
    }
    
    @Override 
    public String toString(){
    	return "" + this.getValor().toString();
    }

	public ArrayList<Vertice<T>> getDestinos() {
        	return this.destinos;
    	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public void setDestinos(ArrayList<Vertice<T>> destinos) {
		this.destinos = destinos;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
}
