public class Experiment {
    public void runTraversals(Graph g, int startNode, String sizeName) {
        System.out.println("\n--- Testing " + sizeName + " Graph ---");
        //bfs
        long start = System.nanoTime();
        g.bfs(startNode);
        long end = System.nanoTime();
        System.out.println("BFS Time: " + (end - start) + " ns");
        //dfs
        start = System.nanoTime();
        g.dfs(startNode);
        end = System.nanoTime();
        System.out.println("DFS Time: " + (end - start) + " ns");
    }

    public void runMultipleTests() {
    }
}