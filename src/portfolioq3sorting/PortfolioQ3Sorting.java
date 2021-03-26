package portfolioq3sorting;

/**
 * Portfolio Question 3
 * SangJoon Lee
 * 30024165
 * 26/03/2021
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PortfolioQ3Sorting {

    public static void main(String[] args) {
        ArrayList<Integer> payroll = new ArrayList<Integer>();
        long startTime;
        long endTime;
        long elapsedTimeInbuild;
        long elapsedTimeMerge;
        long elapsedTimeQuick;
        
        for (int i = 0; i < 100000; i++) {
            Random rand = new Random();
            int rndNo = rand.nextInt(100000);
            payroll.add(rndNo);
        }
        
        // Inbuild Sorting
        ArrayList<Integer> ilist = new ArrayList<Integer>();
        ilist = payroll;
        startTime = System.nanoTime();
        Collections.sort(ilist);
        endTime = System.nanoTime();
        elapsedTimeInbuild = (endTime - startTime) / 1000;
        System.out.println("Builtin Sorting: " + elapsedTimeInbuild + " milliseconds");
        
        // Merge Sorting
        ArrayList<Integer> mlist = new ArrayList<Integer>();
        mlist = payroll;
        startTime = System.nanoTime();
        mergeSort(mlist, 0, (mlist.size() - 1));
        endTime = System.nanoTime();
        elapsedTimeMerge = (endTime - startTime) / 1000;
        System.out.println("Merge Sorting: " + elapsedTimeMerge + " milliseconds");
        
        // Quick Sorting
        ArrayList<Integer> qlist = new ArrayList<Integer>();
        qlist = payroll;
        startTime = System.nanoTime();
//        quickSort(qlist, 0, (mlist.size() - 1));
        endTime = System.nanoTime();
        elapsedTimeQuick = (endTime - startTime) / 1000;
        System.out.println("Quick Sorting: " + elapsedTimeQuick + " milliseconds");
    }
    
    public static void merge(ArrayList<Integer> mlist, int l, int m, int r) {
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
    public static void mergeSort(ArrayList<Integer> mlist, int l, int r) {
        if (l < r) {
            int m = l + (r - 1)/2;
            
            mergeSort(mlist, l, m);
            mergeSort(mlist, m + 1, r);
            
            merge(mlist, l, m, r);
        }
    }
    
    public void quickSort(ArrayList<Integer> qlist) {
        
    }
}
