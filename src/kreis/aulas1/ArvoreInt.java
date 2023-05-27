package kreis.aulas1;


public class ArvoreInt {
    private Node root;

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insertNode(root.left, value);
        } else if (value > root.data) {
            root.right = insertNode(root.right, value);
        }

        return root;
    }

    public void remove(int value) {
        root = removeNode(root, value);
    }

    private Node removeNode(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.data) {
            root.left = removeNode(root.left, value);
        } else if (value > root.data) {
            root.right = removeNode(root.right, value);
        } else {
            // Node to be deleted found
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = findMinValue(root.right);
            root.right = removeNode(root.right, root.data);
        }

        return root;
    }

    private int findMinValue(Node node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    public void printInOrder() {
        printInOrderTraversal(root);
    }

    private void printInOrderTraversal(Node root) {
        if (root != null) {
            printInOrderTraversal(root.left);
            System.out.print(root.data + " ");
            printInOrderTraversal(root.right);
        }
    }

    public void printPreOrder() {
        printPreOrderTraversal(root);
    }

    private void printPreOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printPreOrderTraversal(root.left);
            printPreOrderTraversal(root.right);
        }
    }

    public void printPostOrder() {
        printPostOrderTraversal(root);
    }

    private void printPostOrderTraversal(Node root) {
        if (root != null) {
            printPostOrderTraversal(root.left);
            printPostOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public boolean search(int value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.data) {
            return true;
        } else if (value < root.data) {
            return searchNode(root.left, value);
        } else {
            return searchNode(root.right, value);
        }
    }
}
