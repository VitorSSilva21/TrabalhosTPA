public class Grafo<T> {
    private ArrayList<Aresta> arestas;
    private ArrayList<Vertice<T>> vertices;

    // Outros membros da classe, como vértices e arestas

    public void adicionarAresta(T origem, T destino, float peso) {
        Vertice<T> verticeOrigem, verticeDestino;
        Aresta novaAresta;

        // Busco o vértice com o valor de origem
        verticeOrigem = obterVertice(origem);

        // Se ainda não existe vértice com o valor da origem, vou criar o vértice
        if (verticeOrigem == null)
            verticeOrigem = adicionarVertice(origem);

        // Busco o vértice com o valor de destino
        verticeDestino = obterVertice(destino);

        // Se ainda não existe vértice com o valor do destino, vou criar o vértice
        if (verticeDestino == null)
            verticeDestino = adicionarVertice(destino);

        // Agora crio a aresta que vai de origem para destino
        novaAresta = new Aresta(verticeOrigem, verticeDestino, peso);

        // Adicionei a aresta à Lista do Grafo
        this.arestas.add(novaAresta);
    }

    public Vertice<T> adicionarVertice(T valor) {
        Vertice<T> novo = new Vertice<T>(valor);
        this.vertices.add(novo);
        return novo;
    }

    private Vertice<T> obterVertice(T valor) {
        Vertice<T> v;
        for (int i = 0; i < this.vertices.size(); i++) {
            v = this.vertices.get(i);
            if (v.getValor().equals(valor)) {
                return v;
            }
        }
        // Se chegou aqui é porque não existe um vértice com esse valor
        return null;
    }
}
