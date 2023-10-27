package lib;

import java.util.Comparator;
import lib.ArvoreBinaria;

public class ArvoreAVL <T> extends ArvoreBinaria<T>{

    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
    }

    /**
     * @param No raiz da subarvore com elemento do tipo T armazenado.
     * @return No<T> com a rotação feita no trecho da árvore concluída  para a Esquerda
     */
    private No<T> rotacaoEsquerda(No<T> raiz){
        No<T> rotacionado = raiz.getFilho_direita();
        raiz.setFilho_direita(rotacionado.getFilho_esquerda());
        rotacionado.setFilho_esquerda(raiz);

        return rotacionado;
    }

    /**
     * @param No raiz da subarvore com elemento do tipo T armazenado.
     * @return No<T> com a rotação feita no trecho da árvore concluída para a Direita
     */
    private No<T> rotacaoDireita(No<T> raiz){
        No<T> rotacionado = raiz.getFilho_esquerda();
        raiz.setFilho_esquerda(rotacionado.getFilho_direita());
        rotacionado.setFilho_direita(raiz);

        return rotacionado;
    }

    /**
     * @param No raiz da subarvore com elemento do tipo T armazenado.
     * @return No<T> com a rotação feita no trecho da árvore concluída para a Direita após fazer uma rotação para a Esquerda no Filho à Esquerda da raiz.
     */
    private No<T> rotacaoEsquerdaDireita(No<T> raiz){
        raiz.setFilho_esquerda(this.rotacaoEsquerda(raiz.getFilho_esquerda()));
        return rotacaoDireita(raiz);
    }

    /**
     * @param No raiz da subarvore com elemento do tipo T armazenado.
     * @return No<T> com a rotação feita no trecho da árvore concluída para a Esquerda após fazer uma rotação para a Direita no Filho à Direita da raiz.
     */
    private No<T> rotacaoDireitaEsquerda(No<T> raiz){
        raiz.setFilho_direita(rotacaoDireita(raiz.getFilho_direita()));
        return rotacaoEsquerda(raiz);
    }

@Override
    protected No<T> _adicionar(No<T> raiz, No<T> novo){
        raiz = super._adicionar(raiz,novo);

        if(raiz.fatorBalanceamento() > 1){
            if(raiz.getFilho_direita().fatorBalanceamento() > 0){
                this.rotacaoEsquerda(raiz);
            }
            else{
                this.rotacaoDireitaEsquerda(raiz);
            }
        }else{
            if(raiz.getFilho_esquerda().fatorBalanceamento() < 0){
                this.rotacaoDireita(raiz);
            }
            else{
                this.rotacaoEsquerdaDireita(raiz);
            }
            }
        return raiz;
        }

    public void adicionarElemento(T valor){
        No<T> no = new No<T>(valor);
        if (this.raiz == null){
            this.raiz = no;
        }
        else{
            this.raiz = _adicionar(this.raiz, no);
        }
    }
    
    //Implementar métodos para efetuar o balanceamento e sobrescrever método de adicionar elemento...

}
