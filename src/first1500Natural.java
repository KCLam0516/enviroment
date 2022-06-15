import java.util.ArrayList;
import java.util.List;

class first1500Natural {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int index = 1;
        for (int i = 2; index <= 1500; i++) {
            int number = i;
            List<Integer> factorList = new ArrayList<Integer>();
            if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0) {
                while (number % 2 == 0) {
                    number = number / 2;
                    factorList.add(2);
                }
                while (number % 3 == 0) {
                    number = number / 3;
                    factorList.add(3);
                }
                while (number % 5 == 0){
                    number = number / 5;
                    factorList.add(5);
                }
            }
            if(number == 1){
                System.out.println("Count:" +index + ":number:" + i + " : " + factorList);
                index++;
            }
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution Time: " + executionTime + " milliseconds");
    }
}
