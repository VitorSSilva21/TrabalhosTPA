package lib;

import java.util.Comparator;

public class ArvoreAVL <T> extends ArvoreBinaria<T>{

    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
    }

    /**
     * @param raiz : raiz da subarvore com elemento do tipo T armazenado.
     * @return retorna o elemento rotacionado (filho direita da raiz)
     */
    private No<T> rotacaoEsquerda(No<T> raiz){
        No<T> rotacionado = raiz.getFilho_direita();
        raiz.setFilho_direita(rotacionado.getFilho_esquerda());
        rotacionado.setFilho_esquerda(raiz);	
        return rotacionado;
    }

    /**
     * @param raiz : raiz da subarvore com elemento do tipo T armazenado.
     * @return retorna o elemento que foi rotacionado (filho esquerda da raiz)
     */
    private No<T> rotacaoDireita(No<T> raiz){
        No<T> rotacionado = raiz.getFilho_esquerda();
        raiz.setFilho_esquerda(rotacionado.getFilho_direita());
        rotacionado.setFilho_direita(raiz);
        return rotacionado;
    }

    /**
     * @param raiz : raiz da subarvore com elemento do tipo T armazenado.
     * @return retorna rotacaoDireita(raiz)
     */
    private No<T> rotacaoEsquerdaDireita(No<T> raiz){
        raiz.setFilho_esquerda(this.rotacaoEsquerda(raiz.getFilho_esquerda()));
        return rotacaoDireita(raiz);
    }

    /**
     * @param raiz : raiz da subarvore com elemento do tipo T armazenado.
     * @return retorna rotacaoEsquerda(raiz)
     */
    private No<T> rotacaoDireitaEsquerda(No<T> raiz){
        raiz.setFilho_direita(rotacaoDireita(raiz.getFilho_direita()));
        return rotacaoEsquerda(raiz);
    }
    
    /**
     * @param raiz raiz da árvore.
     * @param novo Novo nó a ser adicionado
     * @return raiz da árvore após inserção e balanceamento
     */
	@Override
	    protected No<T> _adicionar(No<T> raiz, No<T> novo){
	        raiz = super._adicionar(raiz,novo);
	
	        if(raiz.fatorBalanceamento() > 1){
	            if(raiz.getFilho_direita().fatorBalanceamento() > 0){
	                raiz = this.rotacaoEsquerda(raiz);
	            }
	            else{
	                raiz = this.rotacaoDireitaEsquerda(raiz);
	            }
	        }
	        else if(raiz.fatorBalanceamento() < -1){
	            if(raiz.getFilho_esquerda().fatorBalanceamento() < 0){
	                raiz = this.rotacaoDireita(raiz);
	            }
	            else{
	                raiz = this.rotacaoEsquerdaDireita(raiz);
	            }
	        }
	        return raiz;
	}

}
