public class Heap {

    HeapNode[] harr;
    int heap_size;
    public Heap(HeapNode[] node_arr, int heap_size){
        this.heap_size = heap_size;
        harr = node_arr;

        int i = (heap_size - 1)/2;
        while (i >= 0)
        {
            MinHeapify(i);
            i--;
        }
    }
    int left(int i) { return (2*i + 1); }

    int right(int i) { return (2*i + 2); }

    void swap(HeapNode[] arr, int i, int j) {
        HeapNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    void MinHeapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l].element < harr[i].element)
            smallest = l;
        if (r < heap_size && harr[r].element < harr[smallest].element)
            smallest = r;
        if (smallest != i)
        {
            swap(harr, i, smallest);
            MinHeapify(smallest);
        }
    }

    HeapNode getMin()
    {
        if(heap_size <= 0)
        {
            System.out.println("Heap underflow");
            return null;
        }
        return harr[0];
    }
    void replaceMin(HeapNode root) {
        harr[0] = root;
        MinHeapify(0);
    }

    static void printArray(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    static void mergeKSortedArrays(int[][] arr, int k)
    {
        HeapNode[] hArr = new HeapNode[k];
        int resultSize = 0;
        for(int i = 0; i < arr.length; i++)
        {
            HeapNode node = new HeapNode(arr[i][0],i,1);
            hArr[i] = node;
            resultSize += arr[i].length;
        }

        // Create a min heap with k heap nodes. Every heap node
        // has first element of an array
        Heap mh = new Heap(hArr, k);

        int[] result = new int[resultSize];     // To store output array

        // Now one by one get the minimum element from min
        // heap and replace it with next element of its array
        for(int i = 0; i < resultSize; i++)
        {

            // Get the minimum element and store it in result
            HeapNode root = mh.getMin();
            result[i] = root.element;

            // Find the next element that will replace current
            // root of heap. The next element belongs to same
            // array as the current root.
            if(root.j < arr[root.i].length)
                root.element = arr[root.i][root.j++];
                // If root was the last element of its array
            else
                root.element = Integer.MAX_VALUE;

            // Replace root with next element of array
            mh.replaceMin(root);
        }

        printArray(result);

    }




        public static void main(String args[]){
        int[][] arr= {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};

        System.out.println("Merged array is :");

        mergeKSortedArrays(arr,arr.length);
    }



}
