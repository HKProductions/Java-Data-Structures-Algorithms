package com.company;

import java.util.*;

public class WeightedGraph {
    class Vertex{
        int label;
        HashMap<Integer, Integer> edges;

        Vertex(int label){
            this.label = label;
            edges = new HashMap<>();
        }
    }

    HashMap<Integer, Vertex> vertexes;

    WeightedGraph(){
        vertexes = new HashMap<>();
    }

    public void addVertex(int v){
        if(!vertexes.containsKey(v)){
            Vertex node = new Vertex(v);
            vertexes.put(v, node);
        }
    }

    public void addEdge(int v1, int v2, int weight){
        if(!vertexes.containsKey(v1))
            addVertex(v1);

        if(!vertexes.containsKey(v2))
            addVertex(v2);

        Vertex node1 = vertexes.get(v1);
        Vertex node2 = vertexes.get(v2);

        HashMap<Integer, Integer> edge1 = node1.edges;
        HashMap<Integer, Integer> edge2 = node2.edges;

        if(!edge1.containsKey(v2))
            edge1.put(v2, weight);

        if(!edge2.containsKey(v1))
            edge2.put(v1, weight);

        node1.edges = edge1;
        node2.edges = edge2;
    }
}
