package com.algorithms.graphs.dijkstra;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
public class DijkstraAlgorithm {
    private Graph graph;
    private Node source;
    private Set<Node> settledNodes = new HashSet<>();
    private Queue<Node> unsettledNodes = new PriorityQueue<>(( node1,  node2) -> {
            //sort using distance values
            int key1 = node1.getDistance();
            int key2 = node2.getDistance();
            return key1-key2;
        });


    public DijkstraAlgorithm(Graph graph, Node source) {
        this.graph = graph;
        this.source = source;
        source.setDistance(0);
        unsettledNodes.add(source);
    }

    public Graph calculateShortestPathFromSource() {
        while (unsettledNodes.size() != 0) {
            Node evaluationNode = unsettledNodes.poll();
            for (Map.Entry< Node, Integer> adjacencyPair:
                    evaluationNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, evaluationNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(evaluationNode);
        }
        return graph;
    }

    private void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    @Override
    public String toString() {
        return new StringBuilder("DijkstraAlgorithm{")
                .append("graph.nodes.size=").append(graph == null || graph.getNodes() == null ? null : graph.getNodes().size())
                .append(", source=").append(source == null ? null : source.toString())
                .append(", settledNodes.size=").append(settledNodes == null ? null : settledNodes.size())
                .append(", unsettledNodes.size=").append(unsettledNodes == null ? null : unsettledNodes.size())
                .append('}')
                .toString();
    }
}
