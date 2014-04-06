/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import UI.SortingPanel;
import interfaceUIModel.DrawLines;
import interfaceUIModel.UIModelInterface;
import java.util.ArrayList;

/**
 *
 * @author Robert
 */
public abstract class AbstractSortMethod implements Runnable {

    protected ArrayList<Integer> arrayList;
    protected DrawLines UIModelInterface;
    protected int swapFirstElementPosition = -1;
    protected int swapSecondElementPosition = -1;
    protected long startTime = 0;
    protected long stopTime = 0;
    protected long runTime = 0;

    public abstract void sort();

    @Override
    public void run() {
        sort();
    }

    public int getSwapFirstElementPosition() {
        return swapFirstElementPosition;
    }

    public void setSwapFirstElementPosition(int swapFirstElementPosition) {
        this.swapFirstElementPosition = swapFirstElementPosition;
    }

    public int getSwapSecondElementPosition() {
        return swapSecondElementPosition;
    }

    public void setSwapSecondElementPosition(int swapSecondElementPosition) {
        this.swapSecondElementPosition = swapSecondElementPosition;
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    protected void swap(int i, int j) {
        int t = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, t);
    }

    protected void setSwapElements(int firstPosition, int secondPostition) {
        swapFirstElementPosition = firstPosition;
        swapSecondElementPosition = secondPostition;
    }

    protected void resetSwapElements() {
        swapFirstElementPosition = -1;
        swapSecondElementPosition = -1;
    }

    public DrawLines getUIModelInterface() {
        return UIModelInterface;
    }

    public void setUIModelInterface(DrawLines UIModelInterface) {
        this.UIModelInterface = UIModelInterface;
    }
}
