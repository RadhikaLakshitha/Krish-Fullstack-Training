package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Articulation {
    private int node;
    private LinkedList<Integer> list[];
    private int parentNo = -1;


    public Articulation(int x){

        node = x;
        list = new LinkedList[x];

        for (int i = 0; i<x; i++){
            list[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int x, int y){

        list[x].add(y);
        list[y].add(x);
    }


    void checkAP(int u, boolean isvisited[], int dfs_No[], int lowest_dfsNo[], int parent[], boolean articulationPoint[])
    {

        int children = 0;

        // Mark the current node as visited
        isvisited[u] = true;

        // Initialize dfs number and lowest dfs number
        dfs_No[u] = lowest_dfsNo[u] = ++parentNo;


        Iterator<Integer> i = list[u].iterator();
        while (i.hasNext())
        {
            int v = i.next();  // set current adjacent


            if (!isvisited[v])
            {
                children++;
                parent[v] = u;
                checkAP(v, isvisited, dfs_No, lowest_dfsNo, parent, articulationPoint);

                // one of the ancestors of u
                lowest_dfsNo[u]  = Math.min(lowest_dfsNo[u], lowest_dfsNo[v]);


                // check u is root of DFS tree and has two or more children.
                if (parent[u] == parentNo && children > 1)
                    articulationPoint[u] = true;


                if (parent[u] != parentNo && lowest_dfsNo[v] >= dfs_No[u])
                    articulationPoint[u] = true;
            }

            // Update low value of u for parent function calls.
            else if (v != parent[u])
                lowest_dfsNo[u]  = Math.min(lowest_dfsNo[u], dfs_No[v]);
        }
    }



    public void findArticulationPoint(){


        boolean isvisited[] = new boolean[node];
        int dfs_No[] = new int[node]; // array for dfs numbers for each vertex
        int lowest_dfsNo[] = new int[node]; // array for lowest dfs numbers for each vertex
        int parent[] = new int[node]; // store parent nodes
        boolean articulationPoints[] = new boolean[node]; // store articulation points.

        // check parent array, isvisited array and articulationPoints arrays.
        for (int i = 0; i < node; i++)
        {
            parent[i] = parentNo;
            isvisited[i] = false;
            articulationPoints[i] = false;
        }

        //find articulation points
        for (int i = 0; i < node; i++)
            if (isvisited[i] == false)
                checkAP(i, isvisited, dfs_No, lowest_dfsNo, parent, articulationPoints);


        // print articulation points
        for (int i = 0; i < node; i++) {
            if (articulationPoints[i] == true)
                System.out.print(i + " ");

        }


    }

}







