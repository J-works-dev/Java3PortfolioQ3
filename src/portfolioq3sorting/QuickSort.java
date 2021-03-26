package portfolioq3sorting;

import java.util.ArrayList;

public class QuickSort {
    public void swap(ArrayList<Integer> qlist, int i, int j) {
        int temp = qlist.get(i);
        qlist.add(i, qlist.get(j));
        qlist.add(j, temp);
    }
    
    public int partition(ArrayList<Integer> qlist, int low, int high) {
        int pivot = qlist.get(high);
        int i = low - 1;
        
        for(int j = low; j <= high - 1; j++) {
            if (qlist.get(j) < pivot) {
                i++;
                swap(qlist, i, j);  
            }
        }
        swap(qlist, i + 1, high);
        return (i + 1);
    }
    
    public void quickSort(ArrayList<Integer> qlist, int low, int high) {
        if (low < high) {
            int pi = partition(qlist, low, high);
            
            quickSort(qlist, low, pi - 1);
            quickSort(qlist, pi + 1, high);
        }
    }
}
