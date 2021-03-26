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
        MergeSort mg = new MergeSort();
        mlist = payroll;
        startTime = System.nanoTime();
        mg.mergeSort(mlist, 0, (mlist.size() - 1));
        endTime = System.nanoTime();
        elapsedTimeMerge = (endTime - startTime) / 1000;
        System.out.println("Merge Sorting: " + elapsedTimeMerge + " milliseconds");
        
        // Quick Sorting
        ArrayList<Integer> qlist = new ArrayList<Integer>();
        QuickSort qs = new QuickSort();
        qlist = payroll;
        startTime = System.nanoTime();
        qs.quickSort(qlist, 0, (qlist.size() - 1));
        endTime = System.nanoTime();
        elapsedTimeQuick = (endTime - startTime) / 1000;
        System.out.println("Quick Sorting: " + elapsedTimeQuick + " milliseconds");
    }
}
