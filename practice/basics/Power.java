import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Power {
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
    
    // Power(a, b)
    static final int mod = 1_000_000_007;
    static double power(double a, long b) {
        double res = 1;

        boolean check = false;
        if(b < 0) {
            check = true;
            b = -b;
        }

        while(b > 0) {
            //check power
            if((b & 1) != 0) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b = b >> 1; // b/2
        }

        if(check) {
            //res = power(res, mod - 2); // Modular inverse using Fermat's Little Theorem
            
            res = 1 / res;
        }

        return res;
    }

    // Main solution method
    static void solve(FastReader sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(power(a, b));
    }
    
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        // For single test case:
        solve(sc);
        
    }
}
