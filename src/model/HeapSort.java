/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import UI.SortingPanel;
import interfaceUIModel.UIModelInterface;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert
 */
public class HeapSort
        extends AbstractSortMethod {

    private int n;

    public HeapSort() {
        n = 0;
        resetSwapElements();
    }

    private void buildHeap() {
        n = arrayList.size() - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxHeap(i);
        }
    }

    private void maxHeap(int i) {
        int left;
        int right;
        int largest;

        left = 2 * i;
        right = 2 * i + 1;
        if (left <= n && arrayList.get(left) > arrayList.get(i)) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= n && arrayList.get(right) > arrayList.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            setSwapElements(i, largest);
            UIModelInterface.UpdateUI();
            try {
                sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(QuickSort.class.getName()).log(Level.SEVERE, null, ex);
            }

            swap(i, largest);
            UIModelInterface.UpdateUI();
            maxHeap(largest);
        }
    }

    @Override
    public void sort() {
        resetSwapElements();
        buildHeap();
        for (int i = n; i > 0; i--) {
            setSwapElements(0, i);
            UIModelInterface.UpdateUI();

            try {
                sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(QuickSort.class.getName()).log(Level.SEVERE, null, ex);
            }

            startTime = System.currentTimeMillis();
            swap(0, i);
            stopTime = System.currentTimeMillis();
            runTime += stopTime - startTime;
            UIModelInterface.UpdateUI();
            n -= 1;
            maxHeap(0);
        }
        resetSwapElements();
        UIModelInterface.UpdateUI();
    }
}
