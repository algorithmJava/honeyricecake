package com.example.javastudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2630 {
    static int white = 0;
    static int blue = 0;

    static int findConfetti(boolean[][] arr, int row, int col, int size)
    {
        if(size == 1)
        {
            if(arr[row][col]) return 1; // 파란색
            else return 0; // 흰색
        }

        int[] colors = new int[3];

        colors[findConfetti(arr, row, col, size/2)] ++;
        colors[findConfetti(arr, row, col + size/2, size/2)] ++;
        colors[findConfetti(arr,row + size/2, col, size/2)] ++;
        colors[findConfetti(arr, row + size/2, col + size/2, size/2)] ++;

        if(colors[0] == 4) return 0;
        if(colors[1] == 4) return 1;

        // 색깔 4개가 같지 않으면

        white += colors[0];
        blue += colors[1];

        return 2; // 처리가 끝난 경우 2 리턴
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N][N];

        for(int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
            {
                arr[i][j] = st.nextToken().equals("1");
            }
        }

        int x = findConfetti(arr,0, 0, N);
        if(x == 0) white = 1;
        if(x == 1) blue = 1;

        System.out.println(white);
        System.out.println(blue);

    }
}
