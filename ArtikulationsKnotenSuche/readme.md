# ArtikulationsKnotenSuche

Implements (Tarjan's) algorithm, not introduced as such in the lecture, on an undirected connected graph.

## Current functionality:
Before you can use ArtikulationsKnotenSuche.search(), you must first set ArtikulationsKnotenSuche.graph to a graph, built from graph.Graph, of your choosing.
Then, ArtikulationsKnotenSuche.search() will return a HashSet containing all the nodes that are Artikulationsknoten.

_ArtikulationsKnotenSucheTest.testSearch() has a working implementation within it._

## To-Do:
* Change the implementation of graph.Graph and graph.GraphNode to instead use [LightGraph](https://github.com/ModumUnlimited/LightGraph) for consistency.
* Decide whether to keep the current 'build your own graph' approach, or if one should add a method for the class to build a graph for the user from given node and adjacency list inputs.