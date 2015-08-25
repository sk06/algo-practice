import java.util.ArrayList;
import java.util.Scanner;


public class TriangleCounter {
    private static int total;
    private static boolean visited[];

    public static int countTriangles(ArrayList[] g) {
        int n = g.length;
        visited = new boolean[n];
        for(int i = 0; i < n; ++i) {
            visited[i] = true;
            dfs(i, i, 0, g);
        }
        return total / 6;
    }

    private static void dfs(int source, int v, int cnt, ArrayList[] g) {
        ++cnt;
        for(int i = 0; i < g[v].size(); ++i) {
            int to = (Integer) g[v].get(i);
            if(!visited[to] && cnt < 3) {
                visited[to] = true;
                dfs(source, to, cnt, g);
            }
            else if(visited[to] && cnt == 3 && to == source) ++total;
        }
        visited[v] = false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList g[];
        int n = in.nextInt(), m = in.nextInt();
        g = new ArrayList[n];
        for(int i = 0; i < n; ++i) g[i] = new ArrayList();
        for(int i = 0; i < m; ++i) {
            int src = in.nextInt(), dest = in.nextInt();
            g[src].add(dest); g[dest].add(src);
        }
        /*
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < g[i].size(); ++j)
                System.out.print(g[i].get(j) + " ");
            System.out.println();
        }
        */
        System.out.println(countTriangles(g));
    }
}