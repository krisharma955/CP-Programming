import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class PrimeNumber {
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
    
    static boolean isPrime(int n) {
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        for(int i = 3; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    // Simple Sieve
    static int[] sieve(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(prime[i]) {
                for(int j = i*i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < prime.length; i++) {
            if(prime[i]) count++;
        }

        int[] res = new int[count];
        int idx = 0;
        for(int i = 2; i < prime.length; i++) {
            if(prime[i]) res[idx++] = i;
        }

        return res;
    }

    // Segmented Sieve
    static List<Integer> simpleSieve(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for(int i = 2; i * i <= n; i++) {
            if(prime[i]) {
                for(int j = i*i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i < prime.length; i++) {
            if(prime[i]) primes.add(i);
        }

        return primes;
    }
    static void segmentedSieve(int l, int r) {
        int limit = (int) (Math.floor(Math.sqrt(r)) + 1);
        List<Integer> primes = simpleSieve(limit);

        boolean[] arePrimes = new boolean[r - l + 1];
        Arrays.fill(arePrimes, true);

        for(int p : primes) {
            int start = Math.max(p*p, ((l + p - 1) / p) * p);
            for(int i = start; i <= r; i += p) {
                arePrimes[i - l] = false;
            }
        }

        if(l == 1) arePrimes[0] = false;

        for(int i = 0; i < arePrimes.length; i++) {
            if(arePrimes[i]) {
                System.out.print((i + l) + " ");
            }
        }
        
    }

    static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // Main solution method
    static void solve(FastReader sc) {
        //int n = sc.nextInt();

        // System.out.println(isPrime(n));

        // Prime numbers (1 to n)
        //printArray(sieve(n));

        // Primes in range (l, r)
        int l = sc.nextInt();
        int r = sc.nextInt();
        segmentedSieve(l, r);
    }
    
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        
        // For multiple test cases, uncomment:
        // int t = sc.nextInt();
        // while (t-- > 0) {
        //     solve(sc);
        // }

        // For single test case:
        solve(sc);
        
    }
}
