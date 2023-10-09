package lib;
import java.util.ArrayList;
import java.util.Comparator;

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

    /**
     * Método privado para adicionar um elemento na árvore.
     * @param valor - será utilizado para passar a raiz da árvore ou subárvore.
     * @param novo - será utilizado para passar o nó que será adicionado.
     * @return No 1° caso retorna o novo nó caso a árvore esteja vazia.
     * No 2° caso retorna a raiz da árvore com o nó adicionado.
     */
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

    /**
     * Método público para adicionar um elemento na árvore.
     * @param valor - será utilizado para passar o valor da chave a ser adicionado.
     * @return Apesar do método ser void a IDE Eclipse reclama se não tiver um retorno.
     */
    @Override
    public void adicionar(T novoValor) {
    	No<T> novo = new No<T>(novoValor);
    	this.raiz =  _adicionar(this.raiz, novo);
        return;
    }

  /**
     * Método privado para pesquisar por um elemento na árvore e retorná-lo.
     * @param valor - será utilizado para passar o valor da chave a ser buscada
     * @param r - será utilizado para passar o nó "atual".
     * Por exemplo, se for um árvore de Alunos indexada por nome, deve-se passar um objeto do tipo aluno com o nome que se deseja buscar.
     * @return caso tenha sido encontrado um elemento com o valor buscado, o mesmo será retornado. Caso contrário retorna null.
     */
    private T _pesquisar(T valor, No<T> r){
        if(r==null) {
        	return null;
        }
        else{
        	if (comparador.compare(r.getChave(), valor) == 0) {
        		return r.getChave();
        	}
        	else{
        		if(comparador.compare(valor, r.getChave()) < 0){
            		return _pesquisar(valor,r.getFilho_esquerda());
            	}
            	else{
            		return _pesquisar(valor,r.getFilho_direita());
            	}	
        	}	
        }
    }

    /**
     * Método público para pesquisar por um elemento na árvore e retorná-lo.
     * @param valor - será utilizado para passar o valor da chave a ser buscada.
     * Por exemplo, se for um árvore de Alunos indexada por nome, deve-se passar um objeto do tipo aluno com o nome que se deseja buscar.
     * @return No 1° caso retornará  o resultado do método privado de pesquisa passando o valor e a raiz como parâmetros.
     * Caso contrário retorna null.
     */
    @Override
    public T pesquisar(T valor) {
        if(this.raiz != null){
            return _pesquisar(valor,this.raiz);
        }
        else {
        	return null;
        }
    }

    /**
     * Método público que remove um nó da árvore.
     * @param valor - será utilizado para passar o valor da chave a ser removido.
     * @return ????
     */
    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método privado que retorna a altura da árvore.
     * @return No 1° caso retorna 0 quando.
     * a altura da árvore. Árvores só com raiz tem altura zero(0). Se raiz for nula retorne -1. 
     */ 
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

    /**
     * Método público que retorna a altura da árvore.
     * @return chama o método privado de calcular altura passando a raiz como parâmetro.
     */
    @Override
    public int altura() {
        return _altura(this.raiz);
    }

    
    /**
     * Método privado que retorna a quantidade de nós da árvore.
     * @return No 1° caso retorna 0 quando a raiz da árvore é nula.
     * No 2° retorna 1 + a quantidade de nós da subárvore à esquerda + a quantidade de nós da subárvore à direita.
     */
    private int _quantidadeNos(No<T> no){
        if(no == null){
            return 0;
        }
        else {
            return 1 + _quantidadeNos(no.getFilho_esquerda()) + _quantidadeNos(no.getFilho_direita());
        }
    }

    /**
     * Método público que retorna a quantidade de nós da árvore.
     * @return a quantidade de nós da árcore.
     */
    @Override
    public int quantidadeNos() {
        return _quantidadeNos(this.raiz);
    }

    /**
     * Método privado que retona o resultado do caminhamento em nível na árvore.
     * @return No 1° caso retorna uma String com "[]" quando a árvore está vazia.
     * No 2° String contendo os toString dos valores armazenados nos nós, separados por " \n ". Os nós devem ser percorridos em ordem. A String deve iniciar com "[" e finalizar com "]"
     */
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

    /**
     * Metódo privado que retona o resultado do caminhamento em ordem na árvore.
     * @return No 1° caso retorna uma String vazia quando o No r é null. String contendo os toString dos valores armazenados nos nós, separados por " \n ". Os nós devem ser percorridos em ordem. A String deve iniciar com "[" e finalizar com "]"
     */
    private String _caminharEmOrdem(T r) {
        if (r == null) {
            return "";
        }
        return r.toString() + "\n" + this._caminharEmOrdem(this.obterProximo());
    }

    /**
     * Metódo público que retona em uma String o resultado do caminhamento em ordem na árvore.
     * @return retorna uma String contendo os toString dos valores armazenados nos nós, separados por " \n ". Os nós devem ser percorridos em ordem. A String deve iniciar com "[" e finalizar com "]"
     */
    @Override
    public String caminharEmOrdem() {
    	this.reiniciarNavegacao();
        return "[ " + this._caminharEmOrdem( this.obterProximo() ) + "]";
    }

    
    /**
     * Metódo privado que permite iterar sobre os elementos da árvore os retornando em ordem crescente.
     * @return No 1° caso retorna null quando o tamanho da Pilha de Navegação é 0. 
     * No 2° caso retorna o primero nó da pilha de navegação caso não exista filho à direita
     * No 3° caso retorna o primero nó da pilha de navegação
     * A primeira vez que o método for chamado retornará o valor do menor elemento da árvore. Na segunda vez, o segundo menor e assim sucessivamente.
     */
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

    /**
     * Método público que retorna o próximo nó da árvore de forma crescente.
     * @return o próximo nó da árvore de forma crescente a cada chamada.
     */
    @Override
    public T obterProximo(){
    	return this._obterProximo();
    	
    }
    /**
     * Metódo privado auxiliar que permite desempilhar o nó no topo da pilha de navegação.
     * @return Nó desempilhado, chamado aqui de "aux".
     */
    private No<T> desempilhar() {
    	int index = this.pilhaDeNavegacao.size() - 1; 
    	No<T> aux = this.pilhaDeNavegacao.get(index);
    	this.pilhaDeNavegacao.remove(index);
    	return aux;
    }

    /**
     * Metódo privado que permite reiniciar a navegação.
     * @return Ignorar os returns, pois a IDE Eclipse tem algum problema com métodos "void" não retornando algum resultado.
     */
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

    /**
     * Metódo público que permite reiniciar a navegação "esvaziando a pilha", realocando o ArrayList e reiniciando a navegação passando o nó raiz como parâmetro.
     */
    @Override
    public void reiniciarNavegacao() {
    	this.pilhaDeNavegacao = new ArrayList<No<T>>();
        this._reiniciarNavegacao(this.raiz);
    }
  
}
