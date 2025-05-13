public class Reduce {
    public static void main(String[] args) {
        System.out.println(stepCounter(1));
    }

    public static int stepCounter(int n) {
        int step = 0;
        while(n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else {
                n--;
            }
            step ++;
        }
        return step;
    }
}



