package lib;

import java.util.Comparator;
import src.lib.ArvoreBinaria;

public class ArvoreAVL <T> extends ArvoreBinaria<T>{

    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
    }

    /**
     * @param No raiz da subarvore com elemento do tipo T armazenado.
     * @return No<T> com a rotação feita no trecho da árvore concluída  para a Esquerda
     */
    private No<T> rotacaoEsquerda(No<T> raiz){
        No<T> rotacionado = raiz.getFilhoDireita();
        raiz.setFilhoDireita(rotacionado.getFilhoEsquerda());
        rotacionado.setFilhoEsquerda(raiz);

        return rotacionado;
    }

    /**
     * @param No raiz da subarvore com elemento do tipo T armazenado.
     * @return No<T> com a rotação feita no trecho da árvore concluída para a Direita
     */
    private No<T> rotacaoDireita(No<T> raiz){
        No<T> rotacionado = raiz.getFilhoEsquerda();
        raiz.setFilhoEsquerda(rotacionado.getFilhoDireita());
        rotacionado.setFilhoDireita(raiz);

        return rotacionado;
    }

    /**
     * @param No raiz da subarvore com elemento do tipo T armazenado.
     * @return No<T> com a rotação feita no trecho da árvore concluída para a Direita após fazer uma rotação para a Esquerda no Filho à Esquerda da raiz.
     */
    private No<T> rotacaoEsquerdaDireita(No<T> raiz){
        raiz.setFilhoEsquerda(rotaçãoEsquerda(raiz.getFilhoEsquerda()));
        return rotacaoDireita(raiz);
    }

    /**
     * @param No raiz da subarvore com elemento do tipo T armazenado.
     * @return No<T> com a rotação feita no trecho da árvore concluída para a Esquerda após fazer uma rotação para a Direita no Filho à Direita da raiz.
     */
    private No<T> rotacaoDireitaEsquerda(No<T> raiz){
        raiz.setFilhoDireita(rotaçãoDireita(raiz.getFilhoDireita()));
        return rotacaoEsquerda(raiz);
    }
    
    //Implementar métodos para efetuar o balanceamento e sobrescrever método de adicionar elemento...

}
