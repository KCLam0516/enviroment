import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import java.util.Arrays;


public class Environment {
    private String path;

    public static void main(String[] args) { writeHtmlToTxt(); }
    public static void writeHtmlToTxt() {

        ArrayList<Integer> targetPx = new ArrayList<>();
        ArrayList<Integer> sample = new ArrayList<>();
        ArrayList<String> outputPx = new ArrayList<>();

        String file_name = "C:\\CodeEnvironment\\test.txt";
        String outfile_name = "C:\\CodeEnvironment\\testOutput.txt";
        try {
            ReadFile file = new ReadFile(file_name);
            String[] aryLines = file.OpenFile();
            WriteFile data = new WriteFile(outfile_name, true);

            int i;
            for(i=0; i< aryLines.length;i++){
                System.out.println(aryLines[i]);
                String[] target = aryLines[i].split(" ");
                String[] splitTarget = target[2].split("p");
                targetPx.add(Integer.parseInt(splitTarget[0]));
//                String childFilter= ".topRow.var_01 td:nth-child("+(i+1)+"){\n"+"    width: "+target[2]+"\n}";
//                data.writeToFile(childFilter);
            }
            boolean pass=false;
            int target = 0;
            int writeTarget=0;
            for(i=0; i< targetPx.size(); i++){
                for(int j=0; j<targetPx.size(); j++) {
                    if (i==0) {
                        outputPx.add(".topRow.var_01 td:nth-child(" + (i + 1)+")");
                        sample.add(targetPx.get(i));
                        break;
                    }  else if (!targetPx.get(i).equals(targetPx.get(j))) {
                        for(int k=0;k<i;k++){
                            if(targetPx.get(i).equals(targetPx.get(k))){
                                pass=true;
                                target=i;
                                break;
                            }
                        }
                        if(!pass){
                            outputPx.add(".topRow.var_01 td:nth-child(" + (i + 1) + ")");
                            sample.add(targetPx.get(i));
                            System.out.println("execcute");
                            break;
                        } else{
                            String add = ", .topRow.var_01 td:nth-child(" + (i + 1+")");
                            for(int k=0;k<sample.size();k++){
                                if(targetPx.get(target).equals(sample.get(k))){
                                    writeTarget=k;
                                    break;
                                }
                            }
                            outputPx.set(writeTarget,outputPx.get(writeTarget)+add);
                            pass=false;
                        }
                        break;
                    }  else if (targetPx.get(i).equals(targetPx.get(j))) {
                        String add = ", .topRow.var_01 td:nth-child(" + (i + 1+")");
                        outputPx.set(j,outputPx.get(j)+add);
                        break;
                    }
                }
            }

            for(i=0; i< outputPx.size();i++) {
                data.writeToFile(outputPx.get(i)+"{\n    width: "+sample.get(i)+"px;\n}\n");
            }
        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
}

    class widthGenerator {
        private String path;
        public static void main(String[] args) { writeHtmlToTxt(); }
        public static void writeHtmlToTxt() {


            String outfile = "C:\\CodeEnvironment\\widthAndHeight.txt";
            try {
                WriteFile data = new WriteFile(outfile, true);
                int pixelWidthLength = 2001;
                int pixelHeightLength = 201;
                for(int i=1; i!=pixelWidthLength;i++) {
                    data.writeToFile(".tablePadding_w_"+i+"{\n    width:"+i+"px;\n}\n");
                }
                for(int i=1; i!=pixelHeightLength;i++) {
                    data.writeToFile(".tablePadding_h_"+i+"{\n    height:"+i+"px;\n}\n");
                }
            }
            catch (IOException e){
                System.out.print(e.getMessage());
            }
        }
}

class testing1 {
    private String path;
    public static void main(String[] args) { writeHtmlToTxt(); }
    public static void writeHtmlToTxt() {
    List<Integer> a = new ArrayList<Integer>();
    a.add(8);
        a.add(13);
        a.add(5);

        Integer temp = 0;
        for(Integer str:a){
            if(temp==0){
                temp = str;
            } else if(temp<str){
                temp= str;
            }
        }
        System.out.println(temp);
    }
}

class testing3 {
    private String path;
    public static void main(String[] args) throws ParseException { writeHtmlToTxt(); }
    public static void writeHtmlToTxt() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date selectDate =null;
        selectDate = sdf.parse("11/22/33");

        System.out.println(selectDate);

    }
}

//    SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
//    FROM Orders
//    INNER（LEFT,RIGHT,FULL) JOIN Customers ON Orders.CustomerID=Customers.CustomerID;

//    CREATE TABLE table_name (
//    column1 int,
//    column2 varchar(255),
//    column3 varchar(255),
//    column4 varchar(255),
//    column5 varchar(255)
//);

//    UPDATE table_name
//    SET column1 = value1, column2 = value2, ...
//    WHERE condition;

//SELECT * FROM TABLE
//WHERE quantity > X
//ORDER BY order_date DESC
//LIMIT 1;

//SELECT COUNT (order_id),customer_name
//FROM TABLE
//GROUP BY customer_name;


//    public static int invertPyramid(int loop, int starNum) {
//        StringBuilder star = new StringBuilder();
//        for (int i = 0; i < loop; i++) {
//
//            for (int y = 0; y < i; y++) {
//                star.append(" ");
//            }
//
//            for (int x = 0; x < starNum; x++) {
//                star.append("*");
//            }
//
//            System.out.println(star);
//            star = new StringBuilder();
//            starNum -= 2;
//        }
//        return 231231;

//
//    public static int solution(int A)
//    {
//        // hashed array to store count of digits
//        int count[] = new int[10];
//
//        // Converting given number to string
//        String str = Integer.toString(A);
//
//        // Updating the count array
//        for(int i=0; i < str.length(); i++)
//            count[str.charAt(i)-'0']++;
//        System.out.println(count[4]);
//
//        // result is to store the final number
//        int result = 0, multiplier = 1;
//
//        // Traversing the count array
//        // to calculate the maximum number
//        for (int i = 0; i <= 9; i++)
//        {
//            while (count[i] > 0)
//            {
//                result = result + (i * multiplier);
//                count[i]--;
//                multiplier = multiplier * 10;
//            }
//        }
//
//        // return the result
//        return result;
//    }
//}

class L1 {
    static boolean isUnique(String input)
    {

        // 26 characters using its 32 bits.
        int checker = 0;

        for (int i = 0; i < input.length(); i++)
        {
            int val = (input.charAt(i)-'a');

            // If bit corresponding to current
            // character is already set
            if ((checker & (1 << val)) > 0)
                return false;

            // set bit in checker
            checker |= (1 << val);

        }
        return true;
    }

    //driver code
    public static void main (String[] args)
    {
        String s = "abcb";

        System.out.println(isUnique(s));
    }
}

class H2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //create a dummy node and store it in another node so that you will not loose the starting of linked list node
            ListNode dummy=new ListNode(0);
            ListNode head=dummy;
            if(l1==null && l2==null){
                return null;
            }
            if(l1==null){
                return l2;
            }
            if(l2==null){
                return l1;
            }
            int carry=0;
            while(l1!=null || l2!=null){
                //Now check the values of l1 and l2 and store it in n1 & n2 respectively.
                int n1=0;
                int n2=0;
                if(l1!=null){
                    n1=l1.val;
                }
                if(l2!=null){
                    n2=l2.val;
                }
                // Add the values along with carry
                int sum=n1+n2+carry;
                carry=sum/10;
                sum=sum%10;
                //create node with sum and assign it to dummy.next
                dummy.next=new ListNode(sum);
                //increment dummy
                dummy=dummy.next;
                //Now increment l1 & l2
                if(l1!=null){
                    l1=l1.next;
                }
                if(l2!=null){
                    l2=l2.next;
                }

            }
            //outside of while loop, we will check if carry=1, then we have to add extra node.
            if(carry==1){
                dummy.next=new ListNode(1);
                dummy=dummy.next;
            }
            //Un link the dummy node
            head=head.next;
            return head;
        }

    //driver code
    public static void main (String[] args)
    {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(3);


        System.out.println(addTwoNumbers(l1,l2));
    }
}

