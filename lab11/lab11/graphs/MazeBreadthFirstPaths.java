package lab11.graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        // Add more variables here!
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
        Queue<Integer> q = new LinkedList<>();
//        System.out.println(s);
        q.offer(s);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (!marked[curr]) {
                marked[curr] = true;
                if (curr == t) {
                    targetFound = true;
                    announce();
                    return;
                }
                for (int w : maze.adj(curr)) {
                    if (!marked[w]) {
                        q.offer(w);
                        edgeTo[w] = curr;
                        announce();
                        distTo[w] = distTo[curr] + 1;
                    }
                }
            }
        }
    }


    @Override
    public void solve() {
         bfs();
    }
}

