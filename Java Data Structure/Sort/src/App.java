public class App {
    public static void main(String[] args) throws Exception {
        
        Integer[] arrSS = {27, 10, 12, 20, 25, 13, 15, 22};
        Select<Integer> selectSort = new Select<>();
        selectSort.selectSort(arrSS);

        // System.out.println();

        // Integer[] arrIS = {27, 10, 12, 20, 25, 13, 15, 22};
        // Insertion<Integer> insertionSort = new Insertion<>();
        // insertionSort.insertionSort(arrIS);

        // Integer[] arrSH = {27, 10, 22, 20, 25, 13, 15, 3};
        // Shell<Integer> shellSort = new Shell<>();
        // shellSort.shellSort(arrSH);

        // Integer[] arrBS = {27, 10, 22, 20, 25, 13, 15, 3};        
        // Bublle<Integer> bublleSort = new Bublle<>();
        // bublleSort.bubbleSort(arrBS);

        // Merge<Integer> mergeSort = new Merge<>();
        // Integer[] arrM = {27, 10, 12, 20, 25, 13, 22, 15};
        // mergeSort.mergeSort(arrM);

        // Quick<Integer> quickSort = new Quick<>();
        // Integer[] arrQ = {5, 1, 9, 4, 8, 3, 6, 2, 7};
        // quickSort.quickSort(arrQ);

        // Radix radixSort = new Radix<>();
        // Integer[] arrR = {10, 9, 88, 80, 777, 6666, 54321};
        // radixSort.radixSort(arrR);

        // Integer[] arrH = {12, 3, 195, 235, 123, 22};
        // Heap<Integer> heapSort = new Heap<Integer>(arrH);
        // heapSort.heapSort();
        
    }
}
