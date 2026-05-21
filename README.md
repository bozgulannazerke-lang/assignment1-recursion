# README — Dijkstra’s Algorithm (Shortest Path)

## Project Description

This project demonstrates the implementation of Dijkstra’s Algorithm in Java using a weighted directed graph with an adjacency list. The algorithm calculates the shortest distance from a starting vertex to all other vertices in the graph.
---

## Features
* Weighted graph implementation
* Edge class with weight support
* Adjacency list representation
* Dijkstra’s shortest path algorithm
* Outputs shortest distances from the chosen start vertex

---

## Project Structure

### `Edge.java`

Represents a weighted edge in the graph.

Fields:

* `to` — destination vertex
* `weight` — edge weight

Methods:

* `getTo()`
* `getWeight()`

---

### `Graph.java`

Represents the graph using an adjacency list.

Methods:

* `addEdge(int from, int to, int weight)`
* `dijkstra(int start)`

The `dijkstra()` method:

1. Initializes distance and visited arrays
2. Finds the nearest unvisited vertex
3. Updates distances to neighboring vertices
4. Prints the shortest distances

---

### `DijkstraDemo.java`

Contains the `main()` method to test the algorithm.

Creates a graph with 5 vertices and weighted edges, then runs:

```java
g.dijkstra(0);
```

This calculates the shortest paths starting from vertex `0`.

---

## Example Graph

Edges used in the demo:

```text
0 → 1 (10)
0 → 2 (3)
1 → 2 (1)
1 → 3 (2)
2 → 1 (4)
2 → 3 (8)
2 → 4 (2)
3 → 4 (7)
4 → 3 (9)
```

---

## Example Output

```text
Shortest distances from vertex 0:
to 0 = 0
to 1 = 7
to 2 = 3
to 3 = 9
to 4 = 5
```

---

## Algorithm Used

### Dijkstra’s Algorithm

Dijkstra’s Algorithm finds the shortest path from one vertex to all other vertices in a graph with non-negative edge weights.

### Time Complexity

Without a priority queue:

```text
O(V²)
```

Where:

* `V` = number of vertices

---

## Requirements

* Java 8 or higher

---

## How to Run

### Compile

```bash
javac *.java
```

### Run

```bash
java DijkstraDemo
```



