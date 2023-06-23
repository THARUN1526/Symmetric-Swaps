import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

  public static void debug(String a, String b , PrintWriter out) {
     out.println(a + " " + b);
  }
  public static void debug(String a, long b , PrintWriter out) {
     // out.println(a + " " + b);
  }

    // static StringBuilder ans = new StringBuilder();
  // static long[] arr = new long[2];
  static int[] ca = new int[2];
  public static void main(String[] args) throws IOException{
       
    Scanner scn = new Scanner(System.in); 
    FastReader in = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    
    
    
    int ntc = in.nextInt();
    // int ntc = 1;
   
    
    for(int dln = 1 ; dln <= ntc ; dln++){
           yadavDipesh(in , out , scn , dln);
    }
    // out.print(ans);
    out.flush();
  } 

  public static void yadavDipesh(FastReader in , PrintWriter out , Scanner scn , int dln ){
                    int n = in.nextInt() , flag = 0 , temp = 0 , slag = 0;
                    List<Pair> list = new ArrayList<>();
                    
                    for(int i = 0 ; i < n ; i++){
                    	list.add(new Pair(in.nextInt() , i));
                    }
                    for(int i = 0 ; i < n ; i++){
                    	list.add(new Pair(in.nextInt() , i));
                    }
                    
                    
                    Collections.sort(list , (a,b)->{
                    	if(a.x != b.x) return a.x - b.x;
                    	return a.y - b.y;
                    });
                    
                    // out.println(list);
					int[] arr = new int[n];
                    int ans = Integer.MAX_VALUE;
                    int i = 0 , j = 0 , unique = 0;
                    while(j < 2 * n){
                    	// printArray(arr);
						Pair p = list.get(j);
						Pair c = list.get(i);
						arr[p.y]++;
                        if(arr[p.y] == 1) unique++;
                        // out.println(p +" "+ c +" "+ unique);
						if(unique == n){
							// out.println("aya" + (p.x-c.x));
							ans = Math.min(ans , p.x - c.x);
							// out.println("ans " + ans);
							while(unique >= n){
								 Pair pp = list.get(i);
								 ans = Math.min(ans , p.x - pp.x);
								 arr[pp.y]--;
								 if(arr[pp.y] == 0) unique--;
								 i++;
							}
						}
						j++;            	
                    }
                    out.println(ans);
					
                    
        

  }
 
 static class Pair{
 	int x;
 	int y;
 	Pair(int x , int y){
 		this.x = x;
 		this.y = y;
 	}
 	
 	@Override
 	 public String toString(){
 		return"(" + this.x + "," + this.y + ")";
 	}
 }

  /*
             ***  ***   ***   ***   ***   ***   ***   ***   ***   ***  
             
  */
	static final Random random=new Random();
 
	
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}


  public static void getAllPrimesuptoN(int N , int[] isprime , List<Integer> primes){
    for (int i = 2; i <= N ; i++) {
        if (isprime[i] == 1) {
            primes.add(i);
        }
        for (int p : primes) {
            if (i * p > N) {
                break;
            }
            isprime[i * p] = 0;
            if (i % p == 0) {
                break;
            }
        }
    }
  }

  public static int xor(int a , int b){
    return a^b;
  }

  static boolean checkPerfectSquare(long number) {
    double sqrt = Math.sqrt(number);
    return ((sqrt - Math.floor(sqrt)) == 0);
  }
   public static String sortString(String str){
      char[] arr = str.toCharArray();
      Arrays.sort(arr);
      String ans = "";
      for(char ch : arr){
        ans += ch + "";
      }
      return ans;
    }
  static void subString(char str[], int n , ArrayList<String> list) {
    for (int len = 1; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {  
            int j = i + len - 1;
            String ans = "";
            for (int k = i; k <= j; k++) {
                ans += str[k];
            }
            list.add(ans);
        }
    }
  }
 
  static long getPairsCount(int arr[], int n, int k){
    // count of pairs in an array with sum k
      HashMap<Integer, Integer> m = new HashMap<>();
      long count = 0;
      for (int i = 0; i < n; i++) {
          if (m.containsKey(k - arr[i])) {
              count += m.get(k - arr[i]);
          }
          if (m.containsKey(arr[i])) {
              m.put(arr[i], m.get(arr[i]) + 1);
          }
          else {
              m.put(arr[i], 1);
          }
      }
      return count;
  }

   static long mod = 1000000007;
    public static long pow(long a, long b ) {
    long res = 1;
    while (b > 0) {
        if ((b & 1) == 0) {
            a  = (a*a) ;
            b = b >> 1;
        } else {
            res = (res*a) ;
            b--;
        }
    }
    return res;
                }
                
 
  public static boolean checkPalin(String str){
    StringBuilder sb = new StringBuilder(str);
    String rev = sb.reverse().toString();
    if(rev.equals(str)) return true;
    return false;
  }
  
 public static void no(PrintWriter out){
  out.println("NO");
 }
 public static void yes(PrintWriter out){
  out.println("YES");
 }
                 
                  
/*
   static class Pair{
      int first;
      int second;
      Pair( int first , int second){
        this.first =first;
        this.second = second;
      }
    }

  static class Pair{
      int first;
      int second;
      Pair(int first , int second){
        this.first = first;
        this.second = second;
      }
      @Override
      public int hashCode() {
        return (int) (first * 17 + second * 31);
      }
   
      @Override
   
      public boolean equals(Object o) {
   
        Pair p = (Pair) o;
        return this.first == p.first && this.second == p.second;
      }
    }

    static class Pair implements Comparable<Pair>{
        int first;
        int second;
        Pair(int first , int second){
          this.first = first;
          this.second = second;
        }

        public int compareTo(Pair o){
          return this.second - o.second;
        }
      }

*/

  public static void sort(int[] arr){
      //because Arrays.sort() uses quicksort which is dumb
      //Collections.sort() uses merge sort
      ArrayList<Integer> ls = new ArrayList<Integer>();
      for(int x: arr) ls.add(x);
      Collections.sort(ls);
      // Collections.reverse(ls);
      for(int i=0; i < arr.length; i++) arr[i] = ls.get(i);
  }
  public static void reverseSort(int[] arr){
      //because Arrays.sort() uses quicksort which is dumb
      //Collections.sort() uses merge sort
      ArrayList<Integer> ls = new ArrayList<Integer>();
      for(int x: arr) ls.add(x);
      Collections.sort(ls);
      Collections.reverse(ls);
      for(int i=0; i < arr.length; i++) arr[i] = ls.get(i);
  }
  static long gcd(long a, long b) {
     
        while (b != 0) {
          long t = a;
          a = b;  
          b = t % b;
        } 
        return a;
  }    
public static boolean isPrime(long n) {
      if (n <= 1)
        return false;
      if (n <= 3)
        return true;
      if (n % 2 == 0 || n % 3 == 0)
        return false;
      for (long i = 5; i * i <= n; i = i + 6)
        if (n % i == 0 || n % (i + 2) == 0)
          return false;
      return true;
    }
  public static void printArray(int[] arr){
    // System.out.print("arr -> ");
    for(int i = 0 ; i < arr.length ; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void print2dArray(int[][] arr){
    for(int i = 0 ; i < arr.length ; i++){
      for(int j = 0 ; j < arr[0].length ; j++){
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
public static int msb(long val) {
    for (int i = 63; i >= 0; i--)
      if (((val >> i) & 1) == 1)
        return i;
 
    return 0;
}
   
   static int highestPowerof2(int n) {
      int res = 0;
      for (int i = n; i >= 1; i--) {
        if ((i & (i - 1)) == 0) {
          res = i;
          break;
        }
      }
      return res;
    }
public static void primeFactors(int n){
  while (n%2==0){
      System.out.print(2 + " ");
      n /= 2;
  }
  for (int i = 3; i <= Math.sqrt(n); i+= 2){
      while (n%i == 0){
          System.out.print(i + " ");
          n /= i;
      }
  }
  if (n > 2) System.out.print(n);
}
public static void primeFactorsList(int n , ArrayList<Integer> list){
  while (n%2==0){
      list.add(2);
      n /= 2;
  }
  for (int i = 3; i <= Math.sqrt(n); i+= 2){
      while (n%i == 0){
          list.add(i);
          n /= i;
      }
  }
  if (n > 2) list.add(n);
}


  public static String reverse(String str){
    StringBuilder sb = new StringBuilder(str);
    return sb.reverse().toString();
  }

  public static void println(long n){System.out.println(n);} 
  public static void print(long n){System.out.print(n);} 
  public static void print(int n ){System.out.print(n);} 
  public static void println(int n){System.out.println(n);} 

  static class FastReader {
      BufferedReader br;
      StringTokenizer st;
      public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
      }
      String next() {
        while (st == null || !st.hasMoreTokens()) {
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
          str = br.readLine().trim();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return str;
      }
    }


}
