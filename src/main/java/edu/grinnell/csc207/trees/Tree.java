package edu.grinnell.csc207.trees;

import java.util.List;
import java.util.ArrayList;
// import java.util.StringBuffer;

// import apple.laf.JRSUIUtils.Tree;


/**
 * A generic binary tree implementation.
 */
public class Tree<T extends Comparable<? super T>> {

    ///// From the reading
    
    // N.B., the Node<T> class is made public for this lab, so that you can
    // construct trees without an insert-style method!

    private Node<T> root;

    /**
     * Constructs a new, empty binary tree.
     */
    public Tree() {
        root = null;
    }

    /**
     * Constructs a new binary tree with the given root node.
     * @param root the root node of the tree
     */
    public Tree(Node<T> root) {
        this.root = root;
    }

    /**
     * @param node the root of the tree 
     * @return the number elements found in this tree rooted at node
     */
    private int sizeH(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeH(node.left) + sizeH(node.right);
        }
    }

    /** @return the number of elements in the tree */
    public int size() {
        return sizeH(root);
    }

    ///// Part 1: Contains

    /**
     * @param value the value to search for
     * @return true iff the tree contains <code>value</code>. We can set two base cases, where if the value is the target value, or if the Node is null.
     * In the recursive case when we don't have the target value or a non-null Node, then we can do return(contains(left) || contains(right)).
     */
    public boolean contains(T value) {
        // throw new UnsupportedOperationException();
        if (this.root == null) {
            return false;
        }
        if (this.root.value.equals(value)) {
            return true;
        }
        Tree<T> left = new Tree<>(this.root.left);
        Tree<T> right = new Tree<>(this.root.right);
        return left.contains(value) || right.contains(value);
    }

    ///// Part 2: toString
   
    /**
     * @return a string represent of this tree in the form, "[x1, ..., xk]."
     * The order of the elements is left unspecified.
     * This method calls for a helper function that appends the value of the node, then recursively calls the left child and the right child.
     * To solve the issue with the brackets and commas, I have dealt with this by doing the buf.append for the root in the toString method, and then call
     * the helper function after that, where it adds a comma and then the node value.
     */
    @Override
    public String toString() {
        // throw new UnsupportedOperationException();
        StringBuffer buf = new StringBuffer("[");
        if (this.root != null) {
            buf.append(this.root.value);
            toStringH(this.root.left, buf);
            toStringH(this.root.right, buf);
        }
        buf.append("]");
        return buf.toString();
    }

    public void toStringH(Node<T> tr, StringBuffer buf) {
        if (tr == null) {
            return;
        }
        else {
            buf.append(", ");
            buf.append(tr.value);
            toStringH(tr.left, buf);
            toStringH(tr.right, buf);
        }
    }

    ///// Part 3: Traversals

    /**
     * @return the elements of this tree collected via an in-order traversal
     * The actual method creates a new list and runs that into a helper function, which recursively runs the left side first, then does a list.add of the value of
     * the node, and then recursively call the right side.
     */
    public List<T> toListInorder() {
        // throw new UnsupportedOperationException();
        List<T> lst = new ArrayList<>();
        toListInorderH(root, lst);
        return lst;
    }
    public void toListInorderH(Node<T> tr, List<T> lst) {
        if (tr == null) {
            return;
        }
        toListInorderH(tr.left, lst);
        lst.add(tr.value);
        toListInorderH(tr.right, lst);
    }

    /**
     * @return the elements of this tree collected via a pre-order traversal
     */
    public List<T> toListPreorder() {
        // throw new UnsupportedOperationException();
        List<T> lst = new ArrayList<>();
        toListPreorderH(root, lst);
        return lst;
    }
    public void toListPreorderH(Node<T> tr, List<T> lst) {
        if (tr == null) {
            return;
        }
        lst.add(tr.value);
        toListPreorderH(tr.left, lst);
        toListPreorderH(tr.right, lst);
    }

    /**
     * @return the elements of this tree collected via a post-order traversal
     */
    public List<T> toListPostorder() {
        // throw new UnsupportedOperationException();
        List<T> lst = new ArrayList<>();
        toListPostorderH(root, lst);
        return lst;
    }
    public void toListPostorderH(Node<T> tr, List<T> lst) {
        if (tr == null) {
            return;
        }
        toListPostorderH(tr.left, lst);
        toListPostorderH(tr.right, lst);
        lst.add(tr.value);
    }

    ///// Extra: Pretty Printing
    
    /**
     * @return a string represent of this tree in bulleted list form.
     */
    public String toPrettyString() {
        throw new UnsupportedOperationException();
    }

    /**
     * The main driver for this program
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Nothing to do. 'Run' via the JUnit tests instead!");
    }
}
