# Floyd-Warshell-Algorithm
Used to find shortest path between +ve &amp; -ve weighted graph

Floyd Warshell is an algorithm with

             Time  complexity - O(N^3)
             Space complexity - O(N^2)
             where N= number of vertices
             
Adjancency matrix is needed for this algorithm .
Hence use it only for dense graph.

in this algorithm update adjacency matrix exactly N times.

-ve cycle can be detected, if while updating array we get -ve element at diagonal of matrix
