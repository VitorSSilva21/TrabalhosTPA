package lib;

/**
 *
 * @author lorhan.souza
 * @param <T>
 */
public interface IArvoreBinaria<T> {
    
    /**
     * Método para adicionar um elemento à árvore.
     * @param novoValor - Elemento do Tipo T a ser armazenado na árvore.
     * 
     */
    public void adicionar(T novoValor);


    /**
     * Método para pesquisar por um elemento na árvore e retorná-lo.
     * @param valor - será utilizado para passar o valor da chave a ser buscada. Por exemplo, se for um árvore de Alunos indexada por nome, deve-se passar um objeto do tipo aluno com o nome que se deseja buscar.
     * @return caso tenha sido encontrado um elemento com o valor buscado, o mesmo será retornado. Caso contrário retorna null.
     */
    public T pesquisar(T valor);

    /**
     * Método que busca por um elemento na árvore e, caso encontre, o remove da árvore e o retorna
     * @param valor - será utilizado para passar o valor da chave a ser buscada. Por exemplo, se for um árvore de Alunos indexada por nome, deve-se passar um objeto do tipo aluno com o nome que se deseja buscar.
     * @return caso tenha sido encontrado um elemento com o valor buscado, o elemento será removido da árvore e seu valor (do tipo T) será retornado. Caso contrário retorna null.
     */
    public T remover(T valor);

    /**
     * Método que retorna a altura da árvore
     * @return Retorna a altura da árvore. Árvores só com raiz tem altura zero(0). Se raiz for nula retorne -1. 
     */
    public int altura();

    /**
     * Método que retorna a quantidade de nós da árvore
     * @return Retorna a quantidade de nós da árvore
     */
    public int quantidadeNos();


    /**
     * Metódo que retona o resultado do caminhamento em nível na árvore.
     * @return String contendo os toString dos valores armazenados nos nós, separados por " \n ". Os nós devem ser percorridos em nível. A String deve iniciar com "[" e finalizar com "]"
     */
    public String caminharEmNivel();

    /**
     * Metódo que retona o resultado do caminhamento em ordem na árvore.
     * @return String contendo os toString dos valores armazenados nos nós, separados por " \n ". Os nós devem ser percorridos em ordem. A String deve iniciar com "[" e finalizar com "]"
     */
    public String caminharEmOrdem();


    /**
     * Metódo que permite iterar sobre os elementos da árvore os retornando em ordem crescente. 
     * @return A primeira vez que o método for chamado retornará o valor do menor elemento da árvore. Na segunda vez, o segundo menor e assim sucessivamente.
     */
    public T obterProximo();

    /**
     * Metódo que permite reiniciar a iteração sobre os elementos da árvore.
     * Não tem retorno (void). Quando chamado o iterador voltará para o primeiro elemento da árvore. Assim, a primeira chamada a obterProximo após resetar a navegação vai devolver o valor do menor elemento da árvore.
     */
    public void reiniciarNavegacao();
}
    /*
    public T buscaBinaria(IArvoreBinaria arvore, T valor){
        No no_buscador = arvore.getNo_raiz(); //Coloca o nó buscador como o nó raiz
        
        
        if (no_buscador == null){ //Se não tiver nada na árvore retorna NULL
            return null;
        }
        
        while (no_buscador != null){
            if(valor == no_buscador.getChave()){
                return no_buscador;
            }
            else{
                if (valor < no_buscador.getChave()){
                    no_buscador.getFilho_esquerda();
                }
                else{
                    no_buscador.getFilho_direita();
                }
            }
            
        }
        //LÓGICA FALHA. FAVOR CORRIGIR O CÓDIGO LORHAN!!!!
    }
    
    public No adicionaNo (IArvoreBinaria raiz, IArvoreBinaria no){
        
        if (raiz.No_raiz == null){ ///Testa se o arvore está vazia. Se estiver, retorna o nó
            raiz.setNo_raiz(no);
        }
        
        if (no.getChave() < raiz.No_raiz.getChave()){
            raiz.adicionaNo(raiz.getFilho_esquerda(), no);
        }
        
        while(raiz.No_raiz != null){
            //Se não estiver vazia, 
            if (no.getChave() < raiz.No_raiz.getChave()){
                
            }
        }
        
    }
    */
