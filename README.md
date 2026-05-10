Nazerke Bozgulan, SE-2514

# Assignment 4: Graph Traversal and Representation System
## Project Overview
This project demonstrates the implementation of a graph data structure in Java using an adjacency list representation. The system supports graph traversal algorithms including Breadth-First Search (BFS) and Depth-First Search (DFS).
A graph consists of:
- **Vertices (nodes)** — represent objects or points
- **Edges** — represent connections between vertices
The program creates graphs of different sizes:
- Small graph (10 vertices)
- Medium graph (30 vertices)
- Large graph (100 vertices)
The application performs BFS and DFS traversals and measures their execution time using `System.nanoTime()`.

# Project Structure
```plaintext
assignment3-graphs/
├── src/
│   ├── Vertex.java
│   ├── Edge.java
│   ├── Graph.java
│   ├── Experiment.java
│   └── Main.java
├── docs/
│   ├── screenshots/
│   └── diagrams/
├── README.md
└── .gitignore
```
Class Descriptions:
Vertex Class:
The Vertex class represents a node in the graph.
Fields:
id — unique identifier of the vertex
Methods:
Constructor
getId()
toString()
Example: Vertex v = new Vertex(1);

Edge Class:
The Edge class represents a connection between two vertices.
Fields:
source
destination
Methods:
Constructor
Getters
toString()
Example: Edge e = new Edge(0, 1);

Graph Class:
The Graph class stores the graph using an adjacency list.
Adjacency List
The adjacency list stores connected vertices for each node.
Example:
0 -> [1, 2]
1 -> [3]
2 -> [3]

Methods:
addVertex(Vertex v)
addEdge(int from, int to)
printGraph()
bfs(int start)
dfs(int start)

Experiment Class:
The Experiment class runs traversal tests and measures execution time.
Methods:
runTraversals(Graph g, int startNode, String sizeName)
runMultipleTests()

Algorithm Descriptions:
Breadth-First Search (BFS):
BFS explores the graph level by level.
Steps:
1.Start from the selected node
2.Add it to the queue
3.Visit neighboring vertices
4.Continue until the queue becomes empty
Data Structure Used: Queue
Time Complexity: O(V+E)

Where:
V = number of vertices
E = number of edges
Use Cases
Shortest path in unweighted graphs
Social network analysis
Web crawling

Depth-First Search (DFS):
DFS explores as deep as possible before backtracking.
Steps:
1.Start from the selected node
2.Visit one neighbor deeply
3.Continue recursively
4.Backtrack when no unvisited neighbors remain
Data Structure Used: Stack / Recursion
Time Complexity: O(V+E)
Use Cases:
Path finding
Cycle detection
Topological sorting

Experimental Results:
Execution Time Comparison
| Graph Size | BFS Time (ns) | DFS Time (ns) |
|------------|---------------|---------------|
| 10 vertices | 12542600 ns | 315600 ns |
| 30 vertices | 747400 ns | 2353800 ns |
| 100 vertices | 4020400 ns | 3589100 ns |
Observations
As graph size increases, traversal time also increases.
Both BFS and DFS showed linear growth relative to the number of vertices and edges.
BFS was slightly faster in some tests, while DFS performed similarly.
Traversal order changes depending on graph structure and edge connections.

Analysis Questions:
1. How does graph size affect BFS and DFS performance?
Larger graphs require more processing because there are more vertices and edges to visit. Therefore, execution time increases as graph size increases.

2. Which traversal is faster in your experiments?
In most experiments, BFS and DFS had very similar performance. Small differences occurred because of graph structure and recursion overhead in DFS.

3. Do results match the expected complexity O(V + E)?
Yes. The execution time increased approximately linearly as the graph size increased, which matches the expected complexity of O(V + E).

4. How does graph structure affect traversal order?
Traversal order depends on how vertices are connected. Different edge arrangements produce different visiting sequences in BFS and DFS.

5. When is BFS preferred over DFS?
BFS is preferred when searching for the shortest path in an unweighted graph because it explores vertices level by level.

6. What are the limitations of DFS?
DFS may use more recursion depth and can cause stack overflow in very large graphs. It also does not guarantee the shortest path.
 
![img.png](img.png)
Reflection:
This assignment helped me understand how graph traversal algorithms work and how graphs are represented using adjacency lists. I learned the differences between BFS and DFS and how traversal order changes depending on graph structure.

One challenge during implementation was managing visited vertices correctly to avoid infinite loops. Another challenge was understanding recursion in DFS. Overall, the project improved my understanding of graph algorithms and Java OOP concepts.