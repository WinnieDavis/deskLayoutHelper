import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class ClassroomDisplay extends JFrame {
    Integer classHeight;
    Integer classWidth;
    private String[] orderedNameList;
    public static ArrayList<Integer> seatPlacements;
    private int nameCounter = 0;

    public ClassroomDisplay(Integer classHeight, Integer classWidth, String[] orderedNameList, ArrayList<Integer> seatPlacements){
        this.classHeight = classHeight;
        this.classWidth = classWidth;
        this.orderedNameList = orderedNameList;
        this.seatPlacements = seatPlacements;

        setTitle("ClassroomDisplay");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel grid = new JPanel( new GridLayout(classHeight, classWidth, 2,2));
        grid.setBackground(Color.black);
        JLabel label;
        

            for(int i = 0; i<classHeight*classWidth ; i++){


             label = new JLabel();
            label.setOpaque(true);
            label.setBackground(Color.white);
            label.setFont(new Font("Arial", Font.PLAIN, 20));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);

            if (seatPlacements.contains(i+1)) {
    
                if (nameCounter < orderedNameList.length) {
                    label.setText(orderedNameList[nameCounter]);
                    nameCounter++;
                }
            }

            grid.add(label);
        }//////
        
        
        add(grid);
        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
        }

}
