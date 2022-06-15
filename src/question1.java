import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class question1 {
    public static void main(String[] args) {
        int[] a = new int[]{22,-1,3,-4,55,1};
        System.out.println(sumOfTwoLargestElements(a));
    }

    public static int sumOfTwoLargestElements(int[] a) {
        if(a.length < 1){
            return 0;
        }
        if(a.length==1){
            return a[0];
        }
        if(a.length==2){
            return a[0]+a[1];
        }

        List<Integer> listInteger = Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.sort(listInteger);
        int sumInteger = listInteger.get(listInteger.size()-1) + listInteger.get(listInteger.size()-2);
        return sumInteger;
    }
}
