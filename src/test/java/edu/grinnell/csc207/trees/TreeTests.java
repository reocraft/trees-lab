package edu.grinnell.csc207.trees;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TreeTests {
    private Tree<Integer> makeSampleTree() {
        // TODO: add your sample tree from the reading here!
        Node<Integer> sampleTree = 
        new Node<Integer>(5, 
            new Node<Integer>(2, 
                new Node<Integer>(1, null, null), 
                new Node<Integer>(3, null, null)), 
            new Node<Integer>(8, 
                new Node<Integer>(7, 
                    new Node<Integer>(6, null, null), 
                    null), 
                new Node<Integer>(9, 
                    null, 
                    new Node<Integer>(10, null, null))));
        return new Tree<Integer>(sampleTree);
    }

    @Test
    public void emptyTreeSizeTest() {
        Tree<Integer> tree = new Tree<Integer>();
        assertEquals(0, tree.size());
    }

    @Test
    public void sampleTreeSizeTest() {
        assertEquals(9, makeSampleTree().size());
    }

    @Test
    public void emptyTreeContainsTest() {
        Tree<Integer> tree = new Tree<Integer>();
        assertFalse(tree.contains(7));
        assertFalse(tree.contains(4));
    }

    @Test
    public void sampleTreeContainsTest() {
        Tree<Integer> sampleTree = makeSampleTree();
        assertTrue(sampleTree.contains(6));
        assertFalse(sampleTree.contains(4));
    }

    @Test
    public void emptyTreeToStringTest() {
        Tree<Integer> tree = new Tree<Integer>();
        assertEquals("[]", tree.toString());
    }

    @Test
    public void sampleTreeToStringTest() {
        Tree<Integer> sampleTree = makeSampleTree();
        assertEquals("[5, 2, 1, 3, 8, 7, 6, 9, 10]", sampleTree.toString());
    }

    @Test
    public void basicToListInorderTest() {
        // N.B., need to upcast the Integer[] array to avoid a ClassCastException that
        // arises from downcasting the result of toArray to Integer[].
        assertArrayEquals((Object[]) new Integer[] {1, 2, 3, 5, 6, 7, 8, 9, 10},
                          makeSampleTree().toListInorder().toArray());
    }

    @Test
    public void basicToListPreorderTest() {
        assertArrayEquals((Object[]) new Integer[] {5, 2, 1, 3, 8, 7, 6, 9, 10},
                          makeSampleTree().toListPreorder().toArray());
    }

    @Test
    public void basicToListPostorderTest() {
        assertArrayEquals((Object[]) new Integer[] {1, 3, 2, 6, 7, 10, 9, 8, 5},
                          makeSampleTree().toListPostorder().toArray());
    }
}
