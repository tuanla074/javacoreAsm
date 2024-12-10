import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.println("Enter options \n 1: Sort Integer\n 2: Even sum of Integer\n 3: Min Integer \n other: exit\n");
            Scanner scanner = new Scanner(System.in);
            ArrayList<Integer> numbers = new ArrayList<>();
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter numbers list, typed \"done\" to end");
                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        numbers.add(scanner.nextInt());
                    } else if (scanner.next().equalsIgnoreCase("done")) {
                        break;
                    } else {
                        System.out.println("Input Error");
                    }
                }
                int[] arr = numbers.stream().mapToInt(Integer::intValue).toArray();

                mergeSort(arr, 0, arr.length - 1);
                System.out.println("sorted list:");
                for (int num : arr) {
                    System.out.print(num + " ");
                    System.out.println();
                }
            } else if (choice == 2) {
                System.out.println("Input number n:");
                int n = scanner.nextInt();
                int result = evenSum(n);
                System.out.println("Even sum from 0 to " + n + " : " + result);
            } else if (choice == 3) {
                System.out.println("Enter number of Integer");
                int n = scanner.nextInt();
                System.out.println("Enter Integer List");
                for (int i = 0; i < n; i++) {
                    numbers.add(scanner.nextInt());
                }
                int[] arr = numbers.stream().mapToInt(Integer::intValue).toArray();
                int minVal = minFinder(arr, n);
                System.out.println("Smallest Integer" + minVal);
            } else {
                break;
            }

        }
    }

    public static int minFinder(int[] arr, int n){
        int cur_min = arr[0];
        for(int i = 0; i < n; i++){
            if(cur_min > arr[i]){
                cur_min = arr[i];
            }
        }
        return cur_min;
    }

    public static int evenSum(int n){
        int total = 0;
        for(int i = 0; i <= n; i++){
            if(i % 2 == 0){
                total += i;
            }
        }
        return total;
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right ){
            int mid = left + (right - left)/2;
            mergeSort(arr, left, mid );
            mergeSort(arr, mid+1, right);

            merger(arr, left, mid, right);
        }
    }

    public static void merger(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid ;

        int[] larr = new int[n1];
        int[] rarr = new int[n2];

        for(int i  = 0; i < n1; i++){
            larr[i] = arr[left + i];
        }
        for(int j  = 0; j < n2; j++){
            rarr[j] = arr[j + 1 + mid];
        }
        int i = 0;
        int j = 0;
        int k = left;

        while(i < n1 && j < n2){
            if(larr[i] < rarr[j]){
                arr[k] = larr[i];
                i++;
            } else {
                arr[k] = rarr[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = larr[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = rarr[j];
            j++;
            k++;
        }
    }
}