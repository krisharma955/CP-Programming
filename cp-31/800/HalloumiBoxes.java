import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HalloumiBoxes {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String nextLine() {
            String str = "";
            try {
                if (st != null && st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        
        int[] readIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }

    // Main solution method
    static void solve(FastReader sc) {
        int n = sc.nextInt(); // no of boxes
        int k = sc.nextInt(); // max rev possible

        int[] arr = sc.readIntArray(n);

        int[] cpy = Arrays.copyOf(arr, n);
        Arrays.sort(cpy);

        if(Arrays.equals(arr, cpy) || k > 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
    
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        
        // For multiple test cases, uncomment:
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        
    }
}
