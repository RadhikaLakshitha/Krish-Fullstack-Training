package com.company;

public class Main {

    public static void main(String[] args) {

        BFSExample bfs = new BFSExample(6);
        bfs.addEdge(0,1);
        bfs.addEdge(0,3);
        bfs.addEdge(0,4);
        bfs.addEdge(4,2);
        bfs.addEdge(4,5);
        bfs.addEdge(3,2);

        System.out.println("BFS for the graph : " );
        bfs.BFS(0);
    }
}
