package JiuZhangSenior;

import java.util.*;

public class GraphValidTreeWithBFS {
    public static boolean validTree(int n, int[][] edges){
        if(n == 0){
            return false;
        }

        if(edges.length != n - 1){
            return false;
        }

        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(Integer neighbor : graph.get(node)){
                if(hash.contains(neighbor)){
                    continue;
                }
                hash.add(neighbor);
                queue.offer(neighbor);
            }
        }

        return hash.size() == n;
    }

    private static  Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i ++){
            graph.put(i, new HashSet<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }

    public static void main(String[] args){
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.print(validTree(5, edges));

    }

}
