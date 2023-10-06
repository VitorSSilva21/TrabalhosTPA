package lib;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    protected No<T> raiz = null;
    protected Comparator<T> comparador; 
    protected No<T> atual = null;
    private ArrayList<No<T>> pilhaDeNavegacao = null;
    
    /**
     * Construtor que recebe o objeto para criterio de comparação e o armazena como o comparador (referencia)
     * @param comp - será utilizado para passar o criterio de comparação que será utilizado. Por exemplo: CPF, Nome, Matrícula, ID.
     */
    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }

  //ADICIONAR
    private No<T> _adicionar(No<T> raiz, No<T> novo){
        if (raiz == null) {
            return novo;
        }
        else{
            if (comparador.compare(novo.getChave(), raiz.getChave()) < 0){
               raiz.setFilho_esquerda(_adicionar(raiz.getFilho_esquerda(),novo));
              
            } 
            else {
            	raiz.setFilho_direita(_adicionar(raiz.getFilho_direita(),novo));
            }
            return raiz;
        }
        
    }

    @Override
    public void adicionar(T novoValor) {
    	No<T> novo = new No<T>(novoValor);
    	this.raiz =  _adicionar(this.raiz, novo);
        return;
    }

    private T _pesquisar(T valor){
        this.atual = this.raiz;

        if(comparador.compare(valor, this.atual.getChave()) < 0){
            this.atual.getFilho_esquerda();
            _pesquisar(valor);
        }
        else{
            this.atual.getFilho_direita();
            _pesquisar(valor);
        }

        return this.atual.getChave();
    }
    @Override
    public T pesquisar(T valor) {
        if(this.raiz != null){
            _pesquisar(valor);
        }

        return _pesquisar(valor);
    }

    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  //ALTURA 
    private int _altura(No<T>r) {
        if(r==null) {
        	return 0;
        }
        else if(r.getFilho_esquerda()==null && r.getFilho_direita()==null) {
        	return 0;
        }
        else {
        	int altE = _altura(r.getFilho_direita());
        	int altD = _altura(r.getFilho_esquerda());
        	if(altD>altE) {
        		return 1+altD;
        	}
        	else {
        		return 1+altE;
        	}
        }
    }
    
    @Override
    public int altura() {
        return _altura(this.raiz);
    }

//QUANTIDADE NOS
    private int _quantidadeNos(No<T> no){
        if(no == null){
            return 0;
        }
        else {
            return 1 + _quantidadeNos(no.getFilho_esquerda()) + _quantidadeNos(no.getFilho_direita());
        }
    }

    @Override
    public int quantidadeNos() {
        return _quantidadeNos(this.raiz);
    }

//CAMINHAR EM NIVEL
    
    private String _caminharEmNivel() {
    if (raiz == null) {
        return "[]";
    }
    //fila para em nos em lista
    ArrayList<No<T>> fila = new ArrayList<>();
    fila.add(raiz);

    String resultado = "";
    while (!fila.isEmpty()) {
        No<T> no = fila.remove(fila.size()-1);
        resultado += (no.getChave().toString());

        if (no.getFilho_esquerda() != null) {
            fila.add(no.getFilho_esquerda());
        }
        if (no.getFilho_direita() != null) {
            fila.add(no.getFilho_direita());
        }

        if (!fila.isEmpty()) {
            resultado += ",";
            resultado += "\n";
        }
    }
    resultado += "]";
    return resultado;
}
    @Override
    public String caminharEmNivel() {
    	return _caminharEmNivel();
    }

//CAMINHA EM ORDEM
    private String _caminharEmOrdem(T r) {
        if (r == null) {
            return "";
        }
        return r.toString() + "\n" + this._caminharEmOrdem(this.obterProximo());
    }
    
    @Override
    public String caminharEmOrdem() {
    	this.reiniciarNavegacao();
        return "[ " + this._caminharEmOrdem( this.obterProximo() ) + "]";
    }
    
//OBTER PROXIMO
    private T _obterProximo(){
    	if (this.pilhaDeNavegacao.size() == 0) {
    		this.reiniciarNavegacao();
    		return null;
    	}
    	this.atual = this.desempilhar();
    	if(this.atual.getFilho_direita()==null) {
    		return this.atual.getChave();
    	}
    	else {
    		this.pilhaDeNavegacao.add(this.atual.getFilho_direita());
    		No<T> aux = this.atual.getFilho_direita();
    		while (aux.getFilho_esquerda()!=null) {
    			this.pilhaDeNavegacao.add(aux.getFilho_esquerda());
    			aux = aux.getFilho_esquerda();
    		}
    		return this.atual.getChave();
    	}
    }
    
    @Override
    public T obterProximo(){
    	return this._obterProximo();
    	
    }

    private No<T> desempilhar() {
    	int index = this.pilhaDeNavegacao.size() - 1; 
    	No<T> aux = this.pilhaDeNavegacao.get(index);
    	this.pilhaDeNavegacao.remove(index);
    	return aux;
    }
    
  //REINICIAR NAVEGAÇÃO
    private void _reiniciarNavegacao(No<T> r) {
        if (r == null) {
            return;
        }
        else {
        	_reiniciarNavegacao(r.getFilho_esquerda());
            this.pilhaDeNavegacao.add(r);
        }
        return;
    }
    
    @Override
    public void reiniciarNavegacao() {
    	this.pilhaDeNavegacao = new ArrayList<No<T>>();
        this._reiniciarNavegacao(this.raiz);
    }
  
}
