/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert
 */
public class BubbleSort extends AbstractSortMethod {

    private void bubbleSort() {
        int dim = arrayList.size();
        for (int i = 0; i < dim - 1; i++) {
            for (int j = 1; j < dim; j++) {
                int x = arrayList.get(j - 1).intValue();
                int y = arrayList.get(j).intValue();
                if (x > y) {
                    setSwapElements(j - 1, j);
                    UIModelInterface.UpdateUI();
                    try {
                        sleep(700);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    startTime = System.currentTimeMillis();
                    swap(j - 1, j);
                    stopTime = System.currentTimeMillis();
                    runTime += stopTime - startTime;
                    UIModelInterface.UpdateUI();
                } else {
                    resetSwapElements();
                }
            }
        }
    }

    @Override
    public void sort() {
        resetSwapElements();
        bubbleSort();
        resetSwapElements();
        UIModelInterface.UpdateUI();
    }
}
