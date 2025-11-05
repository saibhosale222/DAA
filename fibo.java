// public class fibo {
//     static int fib(int n) {
//         if (n <= 1)
//             return n; // Base case
//         return fib(n - 1) + fib(n - 2); // Recursive relation
//     }

//     public static void main(String[] args) {
//         int n = 10;
//         System.out.print("Fibonacci Series (Recursive): ");
//         for (int i = 0; i < n; i++) {
//             System.out.print(fib(i) + " ");
//         }
//     }
// }




public class fibo {
    public static void main(String[] args) {
        int n = 10;
        int a = 0, b = 1, c;

        System.out.print("Fibonacci Series (Iterative): ");
        System.out.print(a + " " + b + " ");

        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
