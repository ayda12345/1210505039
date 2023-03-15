public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10000];
// Rastgele dizi oluştur
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }

// Quick sort'u çalıştır ve süreyi ölç
        long startTime = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        System.out.println("Quick sort süresi: " + (endTime - startTime) + " nanosaniye");

// Brute force'u çalıştır ve süreyi ölç
        startTime = System.nanoTime();
        bruteForceSort(arr);
        endTime = System.nanoTime();
        System.out.println("Brute force süresi: " + (endTime - startTime) + " nanosaniye");
    }
    public static void bruteForceSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}