package com.algorithms.graphs.dijkstra;

import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

/*
*
*
*
see https://www.baeldung.com/java-dijkstra

Node B : A –> B (total distance = 10)
Node C : A –> C (total distance = 15)
Node D : A –> B –> D (total distance = 22)
Node E : A –> B –> D –> E (total distance = 24)
Node F : A –> B –> D –> F (total distance = 23)

*
* */

public class DijkstraAlgorithmTest {
    @Test
    public void testCalculateMinimumDistance(){
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = new DijkstraAlgorithm(graph, nodeA).calculateShortestPathFromSource();
        assertThat(graph.getNodes(), not(IsEmptyCollection.empty()));

        String result = graph.getNodes().stream()
                .filter(node -> !node.getName().equals(nodeA.getName()))
                .sorted((node1, node2) -> node1.getName().compareTo(node2.getName()))
                .map(node ->
                    new StringBuilder(node.getName())
                            .append(": ")
                            .append(node.getShortestPath().stream()
                                    .map(n -> n.getName())
                                    .collect(Collectors.joining("->", "", "->" + node.getName())))
                            .append("( totalDistance = ").append(node.getDistance()).append(")")
                            .toString())
                .collect(Collectors.joining("\n"));

        assertNotNull(result);


    }
}
