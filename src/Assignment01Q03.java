public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");
        
        int numOdd = 0;
        int first = 1;
        int second = 1;
        int tmp = 0;
        for (int i = 0; i < x; i++) {
            System.out.print(first);
            if (first % 2 == 1) {
                numOdd++;
            }
            tmp = first + second;
            first = second;
            second = tmp;
            if (i < x - 1) 
                System.out.print(" "); // Make sure we don't print a trailing space
        }
        System.out.println();
        
        ////////////////////////////////////////////////////////////////
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
