import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ClassroomGrid extends JFrame{
    Integer classHeight;
    Integer classWidth;
    public static ArrayList<Integer> seatPlacements = new ArrayList<>();

    public ClassroomGrid(Integer classHeight, Integer classWidth){
        this.classHeight = classHeight;
        this.classWidth = classWidth;
    setTitle("Classroom");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel grid = new JPanel( new GridLayout(classHeight, classWidth, 2,2));
    grid.setBackground(Color.black);

    for(int i = 0; i<classHeight*classWidth; i++){
        JLabel label = new JLabel(Integer.toString(i+1));
        label.setOpaque(true);//make visible
        label.setBackground(Color.white);
        label.setFont(new Font("Arial", Font.PLAIN, 20));

        label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                label.setBackground(Color.darkGray);
                seatPlacements.add(Integer.parseInt(label.getText()));

            }
        });

        grid.add(label);
        
    }
    
    add(grid);
    pack();
    setLocationRelativeTo(null); // Center the window
    setVisible(true);

    }
    
}
