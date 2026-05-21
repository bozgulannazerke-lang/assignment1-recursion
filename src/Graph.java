import java.util.*;

public class Graph {
    private final List<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int n) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to, int weight) {
        adj[from].add(new Edge(to, weight));
    }

    public void dijkstra(int start) {
        int n = adj.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            if (dist[u] == Integer.MAX_VALUE) break;
            visited[u] = true;

            for (Edge e : adj[u]) {
                if (dist[u] + e.getWeight() < dist[e.getTo()]) {
                    dist[e.getTo()] = dist[u] + e.getWeight();
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
}
