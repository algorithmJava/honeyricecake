import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static int[] dp;
    static int N;
    static int K;
    static ArrayDeque<Integer> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  // 수빈이의 위치
        K = sc.nextInt();  // 동생의 위치
        
        if(N == K)
        {
            System.out.println(0);
            System.exit(0);
        }

        dp = new int[135001];
        visited = new boolean[135001];
        q = new ArrayDeque<Integer>();

        visited[N] = true;  // 수빈의 최초 위치는 visited
        q.add(N);  // N을 큐에 넣고 시작

        while (q.size() > 0)
        {
            int x = q.remove();
            goTo(x - 1, x);
            goTo(x + 1, x);
            goTo(2 * x, x);
        }
    }

    static void goTo(int cur, int prev)
    {
        if (cur < 0 || cur > 135000) return;
        if (visited[cur]) return;  // 밑의 과정은 visited가 아니므로 prev에서 cur에 최초 도달

        if(cur == K)
        {
            System.out.println(dp[prev] + 1);  // 최초 도달이므로 prev에서 cur에 도달하는 경우가 최적
            System.exit(0);
        }

        visited[cur] = true;  // 이후는 나중에 도달이므로 최적 X
        dp[cur] = dp[prev] + 1;
        q.add(cur);  // visited 체크 후 큐에 넣기, 큐에는 먼저 도달한 순서대로 들어감
    }
}
