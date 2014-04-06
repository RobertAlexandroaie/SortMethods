/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import interfaceUIModel.DrawLines;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.AbstractSortMethod;

/**
 *
 * @author Robert
 */
public class SortingPanel extends JPanel {

    private AbstractSortMethod sortingMethod;
    private DrawLines drawLinesInterface;

    public SortingPanel(AbstractSortMethod sortingMethod) {
        this.sortingMethod = sortingMethod;
        drawLinesInterface = new DrawLines(this);
        this.sortingMethod.setUIModelInterface(drawLinesInterface);
    }

    public AbstractSortMethod getSortingMethod() {
        return sortingMethod;
    }

    public void setSortingMethod(AbstractSortMethod sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(10));
        ArrayList<Integer> unorderedList = sortingMethod.getArrayList();

        int swappedFirstElementPosition = sortingMethod.getSwapFirstElementPosition();
        int swappedSecondElementPosition = sortingMethod.getSwapSecondElementPosition();

        int xPosition = 20;
        int swappedElementsContor = 0;
        for (int iterator : unorderedList) {
            graphics.setColor(Color.black);
            if (swappedFirstElementPosition != -1 && swappedSecondElementPosition != -1 && swappedFirstElementPosition != swappedSecondElementPosition) {
                if (swappedElementsContor == swappedFirstElementPosition
                        || swappedElementsContor == swappedSecondElementPosition) {
                    graphics.setColor(Color.GREEN);
                }
            }
            graphics.drawLine(xPosition, 100 - iterator, xPosition, 100);
            graphics.drawString(String.valueOf(iterator), xPosition, 120);

            xPosition += 20;
            swappedElementsContor++;
        }
    }
}
