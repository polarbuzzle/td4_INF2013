/*
*
* Auteur:   Samuel Ferron - 1843659
*           William La Bereg - 1852751
* Date:     24 octobre 2017
*
* TP4
*
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Comparable;
import java.lang.Math;

public class BST<T extends Comparable<T>>
{
    protected class Node<T>
    {
        T val; // Valeur du noeud
        Node<T> right; // fils droite
        Node<T> left; // fils gauche

        public Node(T val)
        {
            this.val = val;
        }
    }

    protected Node<T> root = null; // Racine de l'arbre

    public boolean isValid() { return isValid(root); }

    private boolean isValid(Node<T> node)
    {
        if (node == null) {
            return true;
        }
        boolean isLeftValid = node.left == null || node.left.val.compareTo(node.val) < 0 && isValid(node.left);
        boolean isRightValid = node.right == null || node.right.val.compareTo(node.val) > 0 && isValid(node.right);
        return isLeftValid && isRightValid;
    }

    public int getHeight() { return root == null ? 0 : getHeight(root); }

    protected int getHeight(Node<T> node)
    {
        // À compléter
        if(node == null)
            return -1;

        return Math.max(1 + getHeight(node.left), 1 + getHeight(node.right));

    }

	public void insert(T elem) { root = insert(root, elem); }

	private Node<T> insert(Node<T> node, T elem)
    {
        // Si node est vide
        if (node == null) {
            node = new Node<>(elem);
            return node;
        }
        // Si elem > node.val
        if (elem.compareTo(node.val) > 0) {
            node.right = insert(node.right, elem);
            return node;
        }
        // Si elem < node.val
        else if (elem.compareTo(node.val) < 0){
            node.left = insert(node.left,elem);
            return node;
        }

        // Sinon (soit elem == node.val)
        return node;
	}

    public boolean contains(T elem) { return contains(root, elem); }

    private boolean contains(Node<T> node, T elem)
    {
        if (node == null)
            return false;

        // Si elem == node.val (il est trouve
        if (elem.equals(node.val))
            return true;

        // Si elem > node.val
        if (elem.compareTo(node.val) > 0)
            return contains(node.right, elem);

        // Si elem < node.val
        else if(elem.compareTo(node.val) < 0)
            return contains(node.left, elem);


        // elem n'est pas dans l'arbre
        return false;
    }

    public ArrayList<T> traversePreOrder()
	{
		ArrayList<T> list = new ArrayList<T>();
		traversePreOrder(root, list);
		return list;
	}

	private void traversePreOrder(Node<T> node, ArrayList<T> list)
	{
        if (node != null) {
            list.add(node.val);
            traversePreOrder(node.left, list);
            traversePreOrder(node.right, list);
        }

	}

    public ArrayList<T> traversePostOrder()
	{
		ArrayList<T> list = new ArrayList<T>();
		traversePostOrder(root, list);
		return list;
	}

	private void traversePostOrder(Node<T> node, ArrayList<T> list)
	{
        if (node != null) {
            traversePostOrder(node.left, list);
            traversePostOrder(node.right, list);
            list.add(node.val);
        }
    }

    public ArrayList<T> traverseInOrder()
    {
        ArrayList<T> list = new ArrayList<T>();
        traverseInOrder(root, list);
        return list;
    }

    private void traverseInOrder(Node<T> node, ArrayList<T> list)
    {
        if (node != null) {
            traverseInOrder(node.left, list);
            list.add(node.val);
            traverseInOrder(node.right, list);
        }
    }

    public ArrayList<T> traverseReverseOrder()
    {
        ArrayList<T> list = new ArrayList<T>();
        traverseReverseOrder(root, list);
        return list;
    }

    private void traverseReverseOrder(Node<T> node, ArrayList<T> list)
    {
        if (node != null) {
            traverseReverseOrder(node.right, list);
            list.add(node.val);
            traverseReverseOrder(node.left, list);
        }
    }

    public ArrayList<T> traverseLevelOrder()
	{
		ArrayList<T> list = new ArrayList<T>();
        Queue<Node> queue = new LinkedList<Node>();
        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            // On ajoute un niveau a la fois dans la queue
            Node<T> node = queue.remove();
            list.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if(node.right!= null) {
                queue.add(node.right);
            }
        }

		return list;
	}
}

