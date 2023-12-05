package Grafo;
import java.util.ArrayList;
import java.util.Comparator;

public class Vertice<T> {
	private T valor;
    private ArrayList<Vertice<T>> destinos;
	private boolean visitado;
    
    public Vertice(T valor){
    	this.valor= valor;
		this.destinos = new ArrayList<Vertice<T>>();
		this.visitado = false;
    }
    
    public boolean addDestino(Vertice<T> dest,Comparator<T> c) {
    	if(destinos.size()==0) {
    		this.destinos.add(dest);
    		return true;
    	}
    	else {
    		for(int i=0;i<destinos.size();i++) {
        		if(c.compare(dest.getValor(), destinos.get(i).getValor())==0){
        			return false;
        		}
        	}
    	}
    	this.destinos.add(dest);
    	return true;    	
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
    	return this.getValor().toString();
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
