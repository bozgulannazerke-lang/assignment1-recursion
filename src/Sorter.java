import java.util.Random;
public class Sorter {

    public void basicSort(int[] arr){
        int n=arr.length;

        for (int i=0; i<n-1; i++){
            int minIndex=i;

            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
                int temp=arr[minIndex];
                arr[minIndex]=arr[i];
                arr[i]=temp;
        }
    }
    public void advancedSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private int partition(int[] arr, int low, int high){
        int pivot=arr[high];
        int i=(low-1);
        for(int j=low; j<high; j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
        }



    public static void printArray(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int[] generateRandomArray(int size){
        Random rand=new Random();
        int[] arr=new int[size];
        for (int i=0; i<size; i++){
            arr[i]=rand.nextInt(1000);
        }
        return arr;
    }
}
