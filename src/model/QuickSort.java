/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Robert
 */
public class QuickSort extends AbstractSortMethod {

    private void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = arrayList.get(low + (high - low) / 2);

        while (i <= j) {
            while (arrayList.get(i) < pivot) {
                i++;
            }
            while (arrayList.get(j) > pivot) {
                j--;
            }
            if (i <= j) {
                setSwapElements(i, j);
                UIModelInterface.UpdateUI();
                try {
                    sleep(700);
                } catch (InterruptedException ex) {
                    Logger.getLogger(QuickSort.class.getName()).log(Level.SEVERE, null, ex);
                }
                startTime = System.currentTimeMillis();
                swap(i, j);
                stopTime = System.currentTimeMillis();
                runTime += stopTime - startTime;
                UIModelInterface.UpdateUI();
                i++;
                j--;
            } else {
                resetSwapElements();
            }
        }
        if (low < j) {
            quicksort(low, j);
        }
        if (i < high) {
            quicksort(i, high);
        }
    }

    @Override
    public void sort() {
        resetSwapElements();
        quicksort(0, arrayList.size() - 1);
        resetSwapElements();
        UIModelInterface.UpdateUI();
    }
}
