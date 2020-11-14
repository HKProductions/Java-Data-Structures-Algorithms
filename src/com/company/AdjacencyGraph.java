package com.company;

import java.util.*;

public class AdjacencyGraph {
    HashMap<String, HashSet<String>> vertex;

    AdjacencyGraph(){
        vertex = new HashMap<>();
    }

    public HashMap<String, HashSet<String>> getVertex(){
        return vertex;
    }

    public void addVertex(String vName){
        HashSet<String> edge = new HashSet<>();

        if(!vertex.containsKey(vName))
            vertex.put(vName, edge);
    }

    public void addEdge(String vertex1, String vertex2){
        if(!vertex.containsKey(vertex1))
            addVertex(vertex1);
        else if(!vertex.containsKey(vertex2))
            addVertex(vertex2);

        HashSet<String> v1Edge = vertex.get(vertex1);
        HashSet<String> v2Edge = vertex.get(vertex2);

        v1Edge.add(vertex2);
        v2Edge.add(vertex1);

        vertex.put(vertex1, v1Edge);
        vertex.put(vertex2, v2Edge);
    }

    public void removeEdge(String vertex1, String vertex2){
        if(!vertex.containsKey(vertex1) || !vertex.containsKey(vertex2))
            return;

        HashSet<String> v1Edge = vertex.get(vertex1);
        HashSet<String> v2Edge = vertex.get(vertex2);

        v1Edge.remove(vertex2);
        v2Edge.remove(vertex1);

        vertex.put(vertex1, v1Edge);
        vertex.put(vertex2, v2Edge);
    }

    public void removeVertex(String v){
        if(!vertex.containsKey(v))
            return;

        HashSet<String> edge = vertex.get(v);
        Iterator<String> itr = edge.iterator();
        ArrayList<String> temp = new ArrayList<>();

        while(itr.hasNext()){
            temp.add(itr.next());
        }

        for(String s : temp){
            removeEdge(v, s);
        }

        vertex.remove(v);
    }
}
