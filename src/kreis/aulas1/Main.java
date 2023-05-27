package kreis.aulas1;

import br.edu.fateczl.arvoreint.*;


public class Main {
    public static void main(String[] args) {
        // a) Criação do vetor fixo com os valores {7, 8, 3, 4, 2, 1, 6, 5}
        int[] vetor = {7, 8, 3, 4, 2, 1, 6, 5};

        // b) Inicialização de uma Árvore de Busca Binária
        ArvoreInt arvore = new ArvoreInt();

        // c) Inserção dos dados do vetor na árvore
        for (int valor : vetor) {
            arvore.insert(valor);
        }

        // d) Remoção dos valores 7 e 6
        arvore.remove(7);
        arvore.remove(6);

        // e) Traversal pré-ordem, em-ordem e pós-ordem dos valores após a remoção
        System.out.println("Traversal pré-ordem:");
        arvore.printPreOrder();

        System.out.println("\nTraversal em-ordem:");
        arvore.printInOrder();

        System.out.println("\nTraversal pós-ordem:");
        arvore.printPostOrder();
    }
}