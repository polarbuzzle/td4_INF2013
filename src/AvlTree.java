/*
*
* Auteur:   Samuel Ferron - 1843659
*           William La Bereg - 1852751
* Date:     24 octobre 2017
*
* TP4
*
 */

import java.lang.Comparable;

public class AvlTree<T extends Comparable<T>> extends BST<T>
{
    public boolean isBalanced() { return isBalanced(root); }

    private boolean isBalanced(Node<T> node)
    {
        if (node == null) {
            return true;
        }

        boolean childsBalanced = isBalanced(node.left)
                              && isBalanced(node.right);

        int heightDiff = Math.abs(getHeight(node.left) - getHeight(node.right));

        return childsBalanced && heightDiff <= 1;
    }

    public void insert(T elem) { root = insert(root, elem); }

    private Node<T> insert(Node<T> node, T elem)
    {
        // Si node est vide
        if (node == null) {
            return node = new Node<>(elem);
        }
        // Si elem > node.val
        else if (elem.compareTo(node.val) > 0) {
            node.right = insert(node.right, elem);
            if(!isBalanced(node)){
                if(elem.compareTo(node.right.val)>0)
                    node = balanceRightRight(node);
                else
                    node = balanceRightLeft(node);
            }
        }
        // Si elem < node.val
        else if (elem.compareTo(node.val) < 0){
            node.left = insert(node.left,elem);
            if(!isBalanced(node)){
                if(elem.compareTo(node.left.val)<0)
                    node = balanceLeftLeft(node);
                else
                    node = balanceLeftRight(node);
            }
        }
        // Sinon (soit elem == node.val)
        return node;

    }

    private Node<T> balanceRightRight(Node<T> node)
    {
        Node newTop = node.right;
        node.right = newTop.left;
        newTop.left = node;

        return newTop;
    }

    private Node<T> balanceRightLeft(Node<T> node)
    {
        node.right = balanceLeftLeft(node.right);
        return balanceRightRight(node);
    }

    private Node<T> balanceLeftLeft(Node<T> node)
    {
        Node newTop = node.left;
        node.left = newTop.right;
        newTop.right = node;
        return newTop;
    }

    private Node<T> balanceLeftRight(Node<T> node)
    {
        node.left = balanceRightRight(node.left);
        return balanceLeftLeft(node);
    }
}