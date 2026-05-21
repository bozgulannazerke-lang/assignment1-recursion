# Graph Traversal and Shortest Path Laboratory Work

This repository contains the implementation of a graph structure supporting multiple traversal algorithms (BFS, DFS) along with an implementation of Dijkstra's Algorithm for finding the shortest path in a weighted graph.

## Bonus Task: Dijkstra’s Algorithm Implementation

As part of the bonus task requirements, the project was extended to support weighted directed graphs, allowing the computation of the shortest distance from a single source vertex to all other reachable vertices.

### Key Modifications & Requirements Met:
1. **Weighted Edges:** The `Edge` class was modified to include a `weight` field (`int weight`) alongside `source` and `destination`.
2. **Graph Structure Update:** The adjacency list (`Map<Integer, List<Edge>>` in the `Graph` class) successfully stores instances of these weighted edges.
3. **Dijkstra's Method:** Implemented the `public void dijkstra(int start)` method using arrays for distance tracking (`dist[]`) and visited flags (`visited[]`). It correctly employs simple nested loops for vertex selection without requiring a priority queue, as permitted by the instructions.
4. **Graph Generation:** Updated the `createRandomGraph` method in `Main.java` to assign random edge weights ranging from 1 to 10.

---

## Code Overview

### 1. Core Classes
* **Vertex:** Represents a node within the graph, uniquely identified by an integer `id`.
* **Edge:** Connects two vertices with a specific directional flow and a defined integer `weight`.
* **Graph:** Manages the structural adjacency list and contains implementation logic for traversals and shortest path computations.
* **Experiment:** A benchmarking utility used to measure and output execution performance times for BFS and DFS in nanoseconds.

### 2. Supported Algorithms
* **Breadth-First Search (BFS):** Explores vertices level-by-level using a standard `Queue` implementation.
* **Depth-First Search (DFS):** Traverses deeper into the graph paths using a recursive approach helper method.
* **Dijkstra's Algorithm:** Calculates the shortest pathways. If a vertex cannot be reached from the specified starting position, the system marks its final distance value as `INF`.

![img.png](img.png) ![img_1.png](img_1.png) ![img_2.png](img_2.png) ![img_3.png](img_3.png)![img_4.png](img_4.png) ![img_5.png](img_5.png)