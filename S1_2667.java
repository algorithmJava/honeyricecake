package com.example.javastudy.ch18;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class DFS {
    boolean[][] apt;
    boolean[][] visited;

    int N;
    ArrayList<Integer> list = new ArrayList<Integer>();

    int complex = 0;
    int houses = 0;

    DFS(int N, boolean[][] arr)
    {
        this.N = N;
        apt = arr;
        visited = new boolean[N + 2][N + 2];
    }

    public void dfs(int i, int j)
    {
        visited[i][j] = true;
        houses += 1;
        int[][] directions = {{i + 1, j}, {i - 1, j}, {i, j - 1}, {i, j + 1}};

        for(int[] dir : directions){
            if(apt[dir[0]][dir[1]] && !visited[dir[0]][dir[1]])
            {
                dfs(dir[0], dir[1]);
            }
        }
    }

    public void findComplex()
    {
        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N; j++)
            {
                if(apt[i][j] && !visited[i][j])
                {
                    complex += 1;
                    houses = 0;
                    dfs(i, j);
                    list.add(houses);
                }
            }
        }
    }

    public void answer()
    {
        System.out.println(complex);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int x: list)
        {
            sb.append(Integer.toString(x));
            sb.append(" ");
        }
        System.out.print(sb);
    }
}

public class S1_2667 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N + 2][N + 2];

        for(int i = 1; i <= N; i++)
        {
            String s = br.readLine();
            for(int j = 1; j <= N; j++)
            {
                if(s.charAt(j - 1) == '1')
                {
                    arr[i][j] = true;
                }
            }
        }

        DFS cur = new DFS(N, arr);

        cur.findComplex();

        cur.answer();

    }
}
