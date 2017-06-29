import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by root on 22.06.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
    /*
        int[] a = new int[]{3,5,7,8,9,1,3,6,4};
        int[] b = new int[]{3,5,7,8,9,1,0,6,19};
        int[] c = new int[]{9,4,9,3,6,7,2,5,1,0};
        int[] d;

        a = Sort.bubbleSort(a);
        b = Sort.selectSort(b);
        c = Sort.insertionSort(c);
        d = Sort.mergeSort(a,b);

        Sort.toStrings(a);
        Sort.toStrings(b);
        Sort.toStrings(c);
        Sort.toStrings(d);

        System.out.println(Sort.lineSearch(a, 15));
        System.out.println(Sort.lineSearch(a, 3));
        //System.out.println(Sort.binarySearch(a, 7));
        System.out.println(Sort.reverceString("hello world"));
        System.out.println(Sort.factCalculate(2));
    */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Operation: \n - bubbleSort  \n - selectSort \n - reverceString \n - factorial \n - search ");

        while (true) {
            System.out.println("Enter the name of operation: ");
            try {
                String lineCode = reader.readLine();
                Sort.interpritateLine(lineCode);
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            System.out.println("More ?  y/n");

            if (reader.readLine().equals("n")) break;



        }
    }
}
