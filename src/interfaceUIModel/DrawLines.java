/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceUIModel;

import UI.SortingPanel;
import javax.swing.JPanel;

/**
 *
 * @author Robert
 */
public class DrawLines implements UIModelInterface {

    private SortingPanel parent;

    public DrawLines(SortingPanel parent) {
        this.parent = parent;
    }

    @Override
    public void UpdateUI() {
        parent.revalidate();
        parent.repaint();
    }
}
