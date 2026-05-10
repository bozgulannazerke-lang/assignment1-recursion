import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Experiment experiment = new Experiment();

        Graph smallGraph = createRandomGraph(10);
        experiment.runTraversals(smallGraph, 0, "Small(10)");

        Graph mediumGraph = createRandomGraph(30);
        experiment.runTraversals(mediumGraph, 0, "Medium(30)");

        Graph largeGraph = createRandomGraph(100);
        experiment.runTraversals(largeGraph, 0, "Large(100)");
    }

    private static Graph createRandomGraph(int size) {
        Graph g = new Graph();
        for (int i = 0; i < size; i++) g.addVertex(new Vertex(i));

        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            // Добавляем случайные ребра
            int edges = rand.nextInt(3) + 1;
            for (int j = 0; j < edges; j++) {
                int target = rand.nextInt(size);
                if (i != target) g.addEdge(i, target);
            }
        }
        return g;
    }
}