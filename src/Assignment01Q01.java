public class Assignment01Q01 {
    public static void main(String[] args) {
        for (String word : args) {
            char ch = word.charAt(0);
            int x = (int) ch;
            if (x % 5 == 0) {
                System.out.println(ch);
            } else{continue;}
        }
        }
    }

