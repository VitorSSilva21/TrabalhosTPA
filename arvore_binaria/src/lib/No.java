package lib;

public class No<T> {
    private T chave; //Armazena objeto de QUALQUER tipo;
    private No<T> filho_esquerda, filho_direita; //Nó de uma árvore binária (sub-árvores esquerda e direita);
    
    /*Construtor da classe No recebe apenas o conteudo para a construção*/
    public No(T conteudo){
        this.chave = conteudo;
        this.filho_esquerda = this.filho_direita = null; //Setando os nós filhos como null;
    }
    
    public No(){
        this.chave = null;
        this.filho_esquerda = this.filho_direita = null; //Setando os nós filhos como null;
    }

    private obterAltura(No<T> raiz){
        
    }
    
    public obterAltura(){
        return obterAltura(this);
    }

    public int fatorBalanceamento(){
        return obterAltura(this.getFilho_direita()) - obterAltura(this.getFilho_esquerda());
    }
    
    /*GETTERs E SETERs*/
    public T getChave() {
        return chave;
    }

    public void setChave(T chave) {
        this.chave = chave;
    }

    public No<T> getFilho_esquerda() {
        return filho_esquerda;
    }

    public void setFilho_esquerda(No<T> filho_esquerda) {
        this.filho_esquerda = filho_esquerda;
    }

    public No<T> getFilho_direita() {
        return filho_direita;
    }

    public void setFilho_direita(No<T> filho_direita) {
        this.filho_direita = filho_direita;
    }
}
