package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSExample {

    private int node;
    private LinkedList<Integer> list[];
    private boolean visited[];

    public DFSExample(int x){

        node = x;
        list = new LinkedList[x];
        visited = new boolean[x];

        for (int i = 0; i<x; i++){
            list[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int x, int y){
        list[x].add(y);
    }

    void DFS(int vertex){

        visited[vertex] = true;               // check visited nodes
        System.out.println(vertex+ " ");

        Iterator<Integer> itr = list[vertex].listIterator();
        while(itr.hasNext()){           // check not visited nodes
            int adjList = itr.next();
            if (!visited[adjList]){
                DFS(adjList);
            }
        }
    }
}
