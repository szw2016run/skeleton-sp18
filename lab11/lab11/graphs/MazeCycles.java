package lab11.graphs;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s = 0;
    boolean cycle = false;

    public MazeCycles(Maze m) {
        super(m);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    @Override
    public void solve() {
        // TODO: Your code here!
        detect(0);
    }

    // Helper methods go here
    public void detect(int v) {
        if (cycle == true) {
            return;
        }
        marked[v] = true;
        for (int w : maze.adj(v)) {
            if (marked[w]) {
                if (edgeTo[v] != w) {
                    edgeTo[w] = v;
                    announce();
                    cycle = true;
                    System.out.println("find");
                    return;
                }
            } else {
                edgeTo[w] = v;
                distTo[w] = distTo[v] + 1;
                detect(w);
            }

        }
    }

}

