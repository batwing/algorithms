package com.algorithms.graphs.dijkstra;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    @Override
    public String toString() {
        return new StringBuilder("Graph{")
                .append("nodes.size=").append(nodes == null ? null : nodes.size())
                .append("}")
                .toString();
    }
}
