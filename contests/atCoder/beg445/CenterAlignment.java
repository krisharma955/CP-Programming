import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CenterAlignment {
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
        
        long[] readLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
    
    // Main solution method
    static void solve(FastReader sc) {
        int n = sc.nextInt();

        String[] arr = new String[n];
        int m = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
            m = Math.max(arr[i].length(), m);
        }

        String[] ans = new String[n];
        for(int i = 0; i < n; i++) {
            if(arr[i].length() < m) {
                int k = m - arr[i].length();
                StringBuilder s = new StringBuilder("");
                for(int j = 0; j < k/2; j++) {
                    s.append(".");
                }
                s.append(arr[i]);
                for(int j = k/2; j < k; j++) {
                    s.append(".");
                }
                ans[i] = s.toString();
            }
            else ans[i] = arr[i];
        }

        for(int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }

    }
    
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        
        solve(sc);
        
    }
}
