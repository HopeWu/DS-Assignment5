# DS-Assignment5

## Project background
We do a project management system. Each project consists of several tasks. Those tasks have inter-dependancies among them. For a given project, the user inputs the all the relavant tasks along with the dependancies for each task and how many days each task takes to finish. At last, the user set a deadline and the system will output one or more sequences of tasks to do with sub deadlines for each.

We implement two underlying graphs. Each underlying graph can be implemented by either adjacency matrix or adjacency list. We compare them.

For the two graphs we are implementing, we could do two decent graphs or do one decent graph and one naive graph. Then, we compare them. Either is okay.

### My proposal is we make it simple. We implement a Dijkstra's and a Bidirectional search. We compare them. Then, we can pick either one and implement it with both adjacency list and adjacency matrix and compare both. Thus, we only do two experiments, 1. compare a Dijkstra's and a Bidirectional search with either implementation of adjacency list or adjacency matrix; 2. compare either graph with two implementations, i.e. adjacency list and adjacency matrix.

> Bidirectional Search
> Bidirectional search is used to find the shortest path between a source and destination node. It operates by essentially running two simultaneous breadth-first searches, one from each node. When their searches collide, we have found a path.

## System design
Assuming we have two options of underlying graph structures to be used.
Assume all the tasks witin a project are connected. There is no left-alone task.

## How the system is used
