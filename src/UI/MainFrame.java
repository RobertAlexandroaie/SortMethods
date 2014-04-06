/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.BubbleSort;
import model.HeapSort;
import model.QuickSort;

/**
 *
 * @author Robert
 */
public final class MainFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    public JButton startButton;
    public JLabel heapSortLabel;
    public SortingPanel heapSortPanel;
    public JLabel quickSortLabel;
    public SortingPanel quickSortPanel;
    public JLabel bubbleSortLabel;
    public SortingPanel bubbleSortPanel;
    public JPanel sortingPanelsPanel;
    private ArrayList<Integer> unorderedList;

    public MainFrame() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        SwingUtilities.updateComponentTreeUI(this.getContentPane());
        initMainFrame();
    }

    public void initMainFrame() {
        initUnorderedList();
        initSortingPanels();
        initButtons();

        GroupLayout mainLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(mainLayout);

        mainLayout.setHorizontalGroup(mainLayout.createParallelGroup()
                .addGroup(mainLayout.createSequentialGroup()
                .addComponent(sortingPanelsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addContainerGap(0, 50))
                .addGroup(mainLayout.createSequentialGroup()
                .addComponent(startButton, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)));
        mainLayout.setVerticalGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sortingPanelsPanel, 350, 350, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(startButton)));
        setMinimumSize(new Dimension((unorderedList.size() + 1) * 21, 570));
        setMaximumSize(new Dimension((unorderedList.size() + 1) * 21, 570));
        pack();
    }

    public void initSortingPanels() {

        sortingPanelsPanel = new JPanel();

        heapSortLabel = new JLabel("HEAP SORT");
        HeapSort heapSort = new HeapSort();
        heapSort.setArrayList((ArrayList<Integer>) unorderedList.clone());

        quickSortLabel = new JLabel("QUICK SORT");
        QuickSort quickSort = new QuickSort();
        quickSort.setArrayList((ArrayList<Integer>) unorderedList.clone());

        bubbleSortLabel = new JLabel("BUBBLE SORT");
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.setArrayList((ArrayList<Integer>) unorderedList.clone());

        heapSortPanel = new SortingPanel(heapSort);
        quickSortPanel = new SortingPanel(quickSort);
        bubbleSortPanel = new SortingPanel(bubbleSort);

        GroupLayout sortingPanlesLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(sortingPanlesLayout);

        sortingPanlesLayout.setHorizontalGroup(sortingPanlesLayout.createParallelGroup()
                .addGroup(sortingPanlesLayout.createSequentialGroup()
                .addComponent(heapSortLabel))
                .addGroup(sortingPanlesLayout.createSequentialGroup()
                .addComponent(heapSortPanel, GroupLayout.DEFAULT_SIZE, unorderedList.size() * 30, Short.MAX_VALUE))
                .addGroup(sortingPanlesLayout.createSequentialGroup()
                .addComponent(quickSortLabel))
                .addGroup(sortingPanlesLayout.createSequentialGroup()
                .addComponent(quickSortPanel, GroupLayout.DEFAULT_SIZE, unorderedList.size() * 30, Short.MAX_VALUE))
                .addGroup(sortingPanlesLayout.createSequentialGroup()
                .addComponent(bubbleSortLabel))
                .addGroup(sortingPanlesLayout.createSequentialGroup()
                .addComponent(bubbleSortPanel, GroupLayout.DEFAULT_SIZE, unorderedList.size() * 30, Short.MAX_VALUE)));
        sortingPanlesLayout.setVerticalGroup(sortingPanlesLayout.createParallelGroup()
                .addGroup(sortingPanlesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(heapSortLabel)
                .addComponent(heapSortPanel, 120, 120, 120)
                .addGap(10, 10, 10)
                .addComponent(quickSortLabel)
                .addComponent(quickSortPanel, 120, 120, 120)
                .addGap(10, 10, 10)
                .addComponent(bubbleSortLabel)
                .addComponent(bubbleSortPanel, 120, 120, 120)));
        pack();
    }

    public void initUnorderedList() {
        unorderedList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            int randomNumber = (int) (Math.random() * 100);
            unorderedList.add(randomNumber);
        }
    }

    public void initButtons() {
        startButton = new JButton("START");
        Dimension buttonDimensionMin = new Dimension(100, 30);
        Dimension buttonDimensionMax = new Dimension(300, 100);

        startButton.setMinimumSize(buttonDimensionMin);
        startButton.setMaximumSize(buttonDimensionMax);

        startButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object sourceButton = e.getSource();
        final MainFrame current = this;

        if (sourceButton instanceof JButton) {
            JButton button = (JButton) sourceButton;


            if (button == startButton) {
                Thread heapSortThread = new Thread(heapSortPanel.getSortingMethod());
                heapSortThread.start();

                Thread quickSortThread = new Thread(quickSortPanel.getSortingMethod());
                quickSortThread.start();

                Thread bubbleSortThread = new Thread(bubbleSortPanel.getSortingMethod());
                bubbleSortThread.start();
            }
        }
    }
}
