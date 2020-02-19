package algo;

import java.util.Arrays;

public class SortingAlgos {
    public static void main(String[] args) {
        int[] array = {-9, 100, 1, 4, 2, 10, -20, 11, 23};
        // bubbleSort(array);
        // insertionSort(array);
        // selectionSort(array);
        // array = mergeSort(array);
        quickSort(array, 0, array.length - 1);
        for(int ele : array) {
            System.out.println(ele);
        }
    }

    private static void bubbleSort(int[] array) {
        for(int i=0; i<array.length;i++) {
            for(int j=0;j<array.length-i-1; j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    private static void insertionSort(int[] array) {
        for(int i=1;i<array.length;i++) {
            int key = array[i];
            int j = i-1;
            while(j>=0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }

    private static void selectionSort(int[] array) {
        // Left of the array is already sorted
        for(int i=0; i<array.length;i++) {
            int min = i;
            int j=i+1;
            for(;j<array.length;j++) {
                if(array[min] > array[j]) {
                    min = j;
                }
            }
            System.out.println(array[min]);
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;

        }
    }

    private static int[] mergeSort(int[] array) {
        if(array.length == 1) return array;
        int mid = ( array.length - 1) / 2 ;
        int [] leftArray = mergeSort(Arrays.copyOfRange(array, 0, mid + 1));
        int [] rightArray = mergeSort(Arrays.copyOfRange(array, mid+1, array.length));
        return merge(leftArray, rightArray);
    }

    private static int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i=0,j=0, k=0;
        for(;i<array1.length && j<array2.length;) {
            if(array1[i] < array2[j]) {
                result[k++] = array1[i++];
            } else if(array1[i] > array2[j]) {
                result[k++] = array2[j++];
            }
        }
        while (i <array1.length) {
            result[k++] = array1[i++];
        }
        while (j <array2.length) {
            result[k++] = array2[j++];
        }
        return result;
    }

    private static void quickSort(int[] array, int low, int high) {
        if(low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        System.out.println("Low >> " + low + " high > " + high);
        int pivot = array[(low + high) / 2];
        int lo = low - 1;
        int hi = high + 1;
        while(true) {
            do {
                lo++;
            } while(array[lo] < pivot);
            do {
                hi--;
            } while(array[hi] > pivot);
            if(lo >= hi) {
                System.out.println("High while returning >> " + hi);
                return hi;
            }
            int temp = array[lo];
            array[lo] = array[hi];
            array[hi] = temp;
        }

    }

}
