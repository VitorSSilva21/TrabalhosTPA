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

    
    private int _obterAltura(No<T> r){
        if (r == null) {
            return -1;
        }
        else{
            int hd = _obterAltura(r.getFilho_direita());
            int he = _obterAltura(r.getFilho_esquerda());
            if(hd>he) {
                return hd + 1;
            }
            else{
                return he + 1;
            }
        }
    }
    
    public int obterAltura(){
        return _obterAltura(this);
    }

    public int fatorBalanceamento(){
    	int alturaDir, alturaEsq = 0;
    	alturaDir = this._obterAltura(this.getFilho_direita());
    	alturaEsq = this._obterAltura(this.getFilho_esquerda());
        return  (alturaDir - alturaEsq);
    }
    
    /*GETTERs E SETERs*/
    public T getChave() {
        return chave;
    }

    public void setChave(T chave) {
        this.chave = chave;
    }

    public No<T> getFilho_esquerda() {
        return this.filho_esquerda;
    }

    public void setFilho_esquerda(No<T> filho_esquerda) {
        this.filho_esquerda = filho_esquerda;
    }

    public No<T> getFilho_direita() {
        return this.filho_direita;
    }

    public void setFilho_direita(No<T> filho_direita) {
        this.filho_direita = filho_direita;
    }
}
