import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoverInWater {
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
    
    static int helper(String str, int n) {
        if(n == 1) {
            if(str.charAt(0) == '.') {
                return 1;
            } else return 0;
        }

        int cnt1 = 0;
        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == '.') {
                int cnt2 = 1;
                for(int j = i+1; j < n; j++) {
                    if(str.charAt(j) == '#') break;
                    cnt2++;
                    if(cnt2 == 3) return 2;
                }
                cnt1++;
            }
        }

        return cnt1;
    }

    // Main solution method
    static void solve(FastReader sc) {
        int n = sc.nextInt(); // no of cells
        String str = sc.next();

        System.out.println(helper(str, n));

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
