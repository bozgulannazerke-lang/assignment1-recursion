import java.util.*;

public class Graph {

    private Map<Integer, List<Edge>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {
        adjList.get(from).add(new Edge(from, to, weight));
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

            for (Edge edge : adjList.getOrDefault(current, new ArrayList<>())) {
                int neighbor = edge.getDestination();

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

        for (Edge edge : adjList.getOrDefault(v, new ArrayList<>())) {
            int neighbor = edge.getDestination();

            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void dijkstra(int start) {
        int n = adjList.size();

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {

            int u = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] &&
                        (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            if (dist[u] == Integer.MAX_VALUE) {
                break;
            }

            visited[u] = true;

            for (Edge edge : adjList.getOrDefault(u, new ArrayList<>())) {

                int v = edge.getDestination();
                int weight = edge.getWeight();

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        System.out.println("Shortest distances from vertex " + start + ":");

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("to " + i + " = INF");
            } else {
                System.out.println("to " + i + " = " + dist[i]);
            }
        }
    }

    public void printGraph() {
        for (int v : adjList.keySet()) {
            System.out.println(v + ": " + adjList.get(v));
        }
    }
}