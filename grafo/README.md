# Implementação de grafo como classe e seus métodos
Esta é uma implementação de grafos direcionais sem ponderação de peso de arestas, feito em java como um trabalho da disciplina de Técnicas de programação avançadas

## Anotações
- Para esta implementação, não foi dada nenhuma interface
- Os grafos devem ser direcionados
- O grafo deve poder aceitar valores de tipo genérico
- No nosso caso, o grafo está representado usando matriz de adjacências
- A classe grafo deve conter os seguintes métodos:
    - Incluir vértice (nó)
    - Incluir aresta (relação)
    - Verificar ciclos: retorna true se houver algum ciclo atualmente no grafo (pesquisar algorítmo DFS)
    - Fazer ordenação topológica: ordenação linear de todos os vértices do grafo: retorna uma lista ordenada dos vértices do grafo

## Relatório
- Após a implementação dos grafos, um relatório deve ser criado com as seguintes seções:
    - Estratégia de representação adotada: explicar a estrutura total da árvore, quais classes foram criadas, quais estruturas auxiliares...
    - Algoritmo de verificação de ciclos: explicar qual algoritmo de verificação de ciclos foi usado e como ele funciona, referenciando qualquer fonte de pesquisa
        - fazer uma análise de complexidade desse método
    - Algoritmo de ordenação topológica: fazer as mesmas coisas que na seção verificação de ciclos
