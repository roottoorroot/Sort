import org.omg.CORBA.SystemException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by root on 22.06.2017.
 */
public class Sort {
    static HashMap <Integer, BigInteger> cache = new HashMap<Integer, BigInteger>();

    //Functions  ---------------------------------
    public static int[] converceStringtoInt(String line) {
        int[] result = new int[line.length()];
        char[] charTmp = line.toCharArray();
        String[] stringTmp = new String[charTmp.length];


        for (int i = 0; i < charTmp.length; i++) {
            stringTmp[i] = Character.toString(charTmp[i]);
        }

        for (int i = 0; i < stringTmp.length; i++) {
            result[i] = Integer.parseInt(stringTmp[i]);
        }

        return result;
    }

    public static void toStrings(int[] a) {
        for (int i: a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    //Bubble Sort---------------------------------
    public static int[] bubbleSort(int[] a) {
        for (int i = a.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }

        return a;
    }

    public static int[] bubbleSort(String line) {
       int[] result = Sort.converceStringtoInt(line);
       return Sort.bubbleSort(result);
    }


    //Select Sort---------------------------------
    public static int[] selectSort(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) min = j;

                //swap
                int tmp = a[min];
                a[min] = a[i];
                a[i] = tmp;
            }
        }

       return a;
    }

    public static int[] selectSort(String line) {
        int[] result = Sort.converceStringtoInt(line);
        return Sort.selectSort(result);
    }


    //Insert Sort---------------------------------
    public static int[] insertionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]){
              int tmp = a[i + 1];
              a[i + 1] = a[i];
              int j = i;
              while (j > 0 && tmp < a[j - 1]) {
                  a[j] = a[j - 1];
                  j--;
              }
              a[j] = tmp;
            }
        }

        return a;
    }

    public static int[] insertionSort(String line) {
        int[] result = Sort.converceStringtoInt(line);
        return Sort.insertionSort(result);
    }

    //Merge Sort  ---------------------------------
    public static int[] mergeSort(int[] a) {
        return a;
    }

    public static int[] mergeSort(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int i = 0;
        int j = 0;

        for (int k = 0; k < c.length; k++) {
            if (i > a.length - 1) {
                int a1 = b[j];
                c[k] = a1;
                j++;
            } else {
                if (j > b.length - 1){
                    int a1 = a[i];
                    c[k] = a1;
                    i++;
                } else {
                    if (a[i] < b[j]) {
                        int a1 = a[i];
                        c[k] = a1;
                        i++;
                    } else {
                       int b1 = a[j];
                       c[k] = b1;
                       j++;
                    }

                }
            }

        }



        return c;
    }

    public static int[] mergeSort(String line) {
        int[] result = Sort.converceStringtoInt(line);
        return Sort.mergeSort(result, result);
    }


    //Line Search Function ---------------------------------
    public static int lineSearch(int[] a, int key) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) res[i] = i;
            else res[i] = -1;
        }
        int search = 0;

        for (int i = 0; i < res.length; i++) {
            if (res[i] != -1) search++;
        }
        return search;
    }

    //Binary search Function---------------------------------
    public static int binarySearch(int[] a, int key) {
       int result = -1;

       int l = 0;
       int u = a.length - 1;
       boolean found = false;


       while (l <= u && !found) {
           int m = (u - l) / 2;
           if (a[m] == key) {
               result = a[m];
               found = true;
           } else if (a[m] < key) l = m + 1;
                  else u = m - 1;
       }

       return result;

    }

    //Reverce String Function ---------------------------------
    public static String reverceString(String line) {

        char[] tmp = line.toCharArray();

        for (int i = tmp.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                char t = tmp[j];
                tmp[j] = tmp[j + 1];
                tmp[j + 1] = t;
            }
        }

        return new String(tmp);
    }

    //Factorial Function --------------------------------------
    public static int factCalculate(int a) {
      if (a == 0) return 1;
      else return a * factCalculate(a - 1);
    }

    //Factorial Fast Function --------------------------------------
    public static BigInteger factCalculateFast(int a) {
            BigInteger ret;

            if (a == 0) return BigInteger.ONE;
            if (null != (ret = cache.get(a))) return ret;
            ret = BigInteger.valueOf(a).multiply(factCalculateFast(a - 1));
            cache.put(a, ret);

            return ret;
    }


    //Interpritator Function --------------------------------------
    public static void interpritateLine(String line) throws IOException {
        String[] tmp = line.split(" ");
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        switch (tmp[0]) {
            case "bubbleSort":  Sort.toStrings(Sort.bubbleSort(tmp[1])); break;
            case "selectSort": Sort.toStrings(Sort.selectSort(tmp[1])); break;
            case "reverceString":
                System.out.println("Enter the String to reverce ...");
                String tmpReverce = Sort.reverceString(reader.readLine());
                System.out.println(tmpReverce);
                break;
            case "factorial":
                System.out.println("Enter the num to calculate a factorial ...");
                int tmpFact = Integer.parseInt(reader.readLine());
                System.out.println(Sort.factCalculate(tmpFact));
                break;
            case "fastfactorial":
                System.out.println("Enter the num to calculate a factorial ...");
                int tmpFastFact = Integer.parseInt(reader.readLine());
                System.out.println(Sort.factCalculateFast(tmpFastFact));
                break;
            case "search":
                System.out.println("Binary or Line ?");
                String quest = reader.readLine();
                if ("Binary".equals(quest)) {
                    String[] binary = reader.readLine().split(" ");

                    int[] tmpBinary = Sort.converceStringtoInt(binary[0]);
                    int tmpkey = Integer.parseInt(binary[1]);

                    System.out.println(Sort.binarySearch(tmpBinary, tmpkey));
                    break;
                }

                if ("Line".equals(quest)) {
                    String[] binary = reader.readLine().split(" ");

                    int[] tmpBinary = Sort.converceStringtoInt(binary[0]);
                    int tmpkey = Integer.parseInt(binary[1]);

                    System.out.println(Sort.lineSearch(tmpBinary, tmpkey));
                    break;
                }
            default:
                System.out.println("Wrong later"); break;
        }

    }



}
