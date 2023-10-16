# binary-tree
This code implements a binary tree with insertion, search and removal.

Análise das estruturas --

Para comparar as duas árvores vamos usar os dados Gerados pelos testes do código (disponiveis ao rodar o código)

De maneira geral a inserção em uma árvore não balanceada é bem mais rápida, tendo em vista que ela não precisa verificar e balancear nada a cada inserção
A remoção funciona de maneira semenlhante. A arvore AVL demora mais para remover elementos, visto que as vezes é necessário verificar e balancear a árvore

A busca e muito mais rapida em uma Arvore Balanceada, tendo em vista que o número de nós que ela percorre para achar o elemento é bem menor, pelo fato de ela estar sempre balanceada.

ARVORE NORMAL
     -Inserção rapida
     -Remoção media
     -Busca lenta

ARVORE BALANCEADA
     -Inserção lenta
     -Remoção lenta
     -Busca muito rápida

Relatório do código --

1. Toda a parte interativa do código é feita na classe Main.
2. A classe Main permite escolher o tipo de arvore e a operação nela.
3. A CLASSE TREE possui a implementação da arvore binária.
4. A CLASSE TreeAVL possui a implementação da arvore binária balanceada.

5. A Classe TREE e TreeAVL possuem funçoes em comum como:
     - Inserção
     - Remoção
     - Busca
     - E busca de um valor maior usando inOrder

6. A Classe TreeAVL possue funções a mais que a classe  Tree
     - Checar balanceameto

7. As Classe das Arvores operam sobre Nós(Nodes) diferentes:
     - Classe Tree opera sobre Node
     - Classe TreeAVL opera sobre AVLnode

8. Node e AVLnode possuem funções em comum:
     - Get and Set Direita
     - Get and Set Esquerda
     - Get and Set Info
     - Get and Set Supper

9. A classe AVLnode possue funções unicas:
     - Checar Balanceamento do Nó
     - Rodar a direita
     - Rodar a Esquerda
     - Rodar duplo a direita
     - Rodar duplo a esquerda
     - Calcular Balanceamento
     - Checar altura

10. Existe uma classe Interface a que reproduz uma interface gráfica para a Arvore NORMAL (Tree).

11. A Arvore AVL não possui interface, mas a integridade de seus nós podem ser vistos em prints no console.
