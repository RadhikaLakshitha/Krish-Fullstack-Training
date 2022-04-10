package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BFSExample {

    private int node;  //number of nodes
    private LinkedList<Integer> list[]; //adjacency list
    private Queue<Integer> queue; // queue declaration


    BFSExample(int x){
        node = x;
        list = new LinkedList[node];

        for (int i = 0; i<x; i++){
            list[i] = new LinkedList<Integer>();
        }
        queue = new LinkedList<Integer>();
    }

    void addEdge(int x, int y){
        list[x].add(y);  // adding an edge to the graph
    }

    void BFS(int x){

        boolean nodes[] = new boolean[node];
        int z = 0;
        queue.add(x); // adding the root node

        while(queue.size() != 0){

            x = queue.poll(); // remove top element of the queue
            System.out.println( x+ " ");

            for (int i = 0; i<list[x].size(); i++){

                z = list[x].get(i);
                    if (!nodes[z]){ //only insert not visited nodes to the queue

                        nodes[z] = true;
                        queue.add(z);
                    }

            }
        }
    }
}
