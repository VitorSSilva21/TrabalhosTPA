package Grafo;
public class Vertice <T> {
    private T valor;
    
    public Vertice(T valor){
    	this.valor = valor;
    }
    
    protected T getValor(){
    	return this.valor;
    }
    
    protected void setValor(T valor) {
    	this.valor = valor;
    }
    
    @Override 
    public String toString(){
    	return "" + getValor() + "/n";
    }
}
