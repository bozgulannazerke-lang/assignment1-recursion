import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList;
    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        adjList.get(from).add(to);
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS Traversal: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int v, Set<Integer> visited) {
        visited.add(v);
        System.out.print(v + " ");

        for (int neighbor : adjList.getOrDefault(v, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void printGraph() {
        for (int v : adjList.keySet()) {
            System.out.println(v + ": " + adjList.get(v));
        }
    }
}