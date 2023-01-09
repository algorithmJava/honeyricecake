import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] arr;
    static boolean[][] visited;

    static int[] dir1 = {1, -1, 0, 0};
    static int[] dir2 = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < N; i++)
        {
            String s = br.readLine();
            for(int j = 0; j < N; j++) arr[i][j] = s.charAt(j);
        }

        visited = new boolean[N][N];

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(!visited[i][j])
                {
                    count1++;
                    dfs1(i, j, arr[i][j]);
                }
            }
        }

        visited = new boolean[N][N];

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(!visited[i][j])
                {
                    count2++;
                    dfs2(i, j, arr[i][j]);
                }
            }
        }

        System.out.println(count1);
        System.out.println(count2);

    }

    static void dfs1(int row, int col, char x)
    {
        visited[row][col] = true;

        if(arr[row][col] == 'G') arr[row][col] = 'R';

        goTo(row, col, x);
    }

    static void dfs2(int row, int col, char x)
    {
        visited[row][col] = true;

        goTo(row, col, x);
    }

    static void goTo(int row, int col, char x) {
        for(int i = 0; i < 4; i++)
        {
            int r = row + dir1[i];
            int c = col + dir2[i];

            if(r < 0 || r >= N || c < 0 || c >= N) continue;
            if(visited[r][c]) continue;

            if(arr[r][c] == x) dfs1(r, c, x);
        }
    }

}
