package portfolioq3sorting;

import java.util.ArrayList;

public class MergeSort {
    public void merge(ArrayList<Integer> mlist, int l, int m, int r) {
        int sizeL = m - l + 1;
        int sizeR = r - m;
        
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        
        for (int i = 0; i < sizeL; i++) {
            left.add(i, mlist.get(i + l));
        }
        for (int j = 0; j < sizeR; j++) {
            right.add(j, mlist.get(m + 1 + j));
        }
        
        int i = 0;
        int j = 0;
        int k = l;
        
        while (i < sizeL && j < sizeR) {
            if (left.get(i) <= right.get(j)) {
                mlist.add(k, left.get(i));
                i++;
            }
            else {
                mlist.add(k, right.get(j));
                j++;
            }
            k++;
        }
        while (i < sizeL) {
            mlist.add(k, left.get(i));
            i++;
            k++;
        }
        while (j < sizeR) {
            mlist.add(k, right.get(j));
            j++;
            k++;
        }
    }
    public void mergeSort(ArrayList<Integer> mlist, int l, int r) {
        if (l < r) {
            int m = l + (r - l)/2;
            
            mergeSort(mlist, l, m);
            mergeSort(mlist, m + 1, r);
            
            merge(mlist, l, m, r);
        }
    }
}
