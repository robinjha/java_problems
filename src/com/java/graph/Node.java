package com.java.graph;

import java.util.Set;

/**
  - The graph should contain at least 10 people
  - Each person should have at least 3, first level "connections" to other people in the graph.
    i.e. Node.children() >= 3 should hold true for all nodes in the graph.
  - The graph should be cyclic
 * @author robin
 *
 */
public interface Node<T> {
    public T name();
    public Set<Node<T>> children();
}
