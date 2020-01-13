package com.algorithms.graphs.dijkstra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Node {
    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    private String name;

    //The list of nodes that describes the shortest path calculated from the starting node
    private List<Node> shortestPath = new LinkedList<>();

    //The distance from the source
    private Integer distance = Integer.MAX_VALUE;//To simulate an infinite distance

    //The adjacentNodes attribute is used to associate immediate neighbors with edge length.
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    @Override
    public String toString() {
        return new StringBuilder("Node{")
                .append("name='").append(name).append('\'')
                .append(", shortestPath.size=").append(shortestPath == null ? null : shortestPath.size())
                .append(", distance=").append(distance)
                .append(", adjacentNodes.size=").append(adjacentNodes == null ? null : adjacentNodes.size())
                .append("}")
                .toString();
    }
}
