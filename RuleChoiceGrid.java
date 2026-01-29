
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;
public class RuleChoiceGrid extends JFrame{
    private ArrayList<String> nameList;
    private ArrayList<String[]> doNotSeatTogether = new ArrayList<>();
    private ArrayList<String[]> seatTogether = new ArrayList<>();
    private String lastListAddedTo;
    public  String FirstClickName = null;
    public String SecondClickName = null;
    public static boolean RuleChoiceComplete = false;
    private ArrayList<JLabel> labelList = new ArrayList<>();



    public RuleChoiceGrid(ArrayList<String> nameList){

        setTitle("RuleChoiceGrid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel grid = new JPanel( new GridLayout(nameList.size()+ 5, 1, 2,2));
        grid.setBackground(Color.black);

        for(int i = 0; i<nameList.size() +5; i++){
            JLabel label;
            if(i == 0){
                 label = new JLabel("Names List");
            }else if(i == nameList.size() + 1){
                  label = new JLabel("click to confirm bad pairing");
                  addBadListener(label);
            }else if(i == nameList.size() + 2){
                  label = new JLabel("click to confirm good pairing");
                  addGoodListener(label);
            }
            else if(i == nameList.size() + 3){
                  label = new JLabel("click to remove previous choice");
                  addRemoveListener(label);
            }
            else if(i == nameList.size() + 4){
                 label = new JLabel("click to finish");
                 addFinishListener(label);
            }else{
                 label = new JLabel(nameList.get(i-1));
                 clickNameListener(label);
            }
            label.setFont(new Font("Arial", Font.PLAIN, 20));
            label.setOpaque(true);//make visible
            label.setBackground(Color.white);


            grid.add(label);
            labelList.add(label);
            
    }
    
    add(grid);
    pack();
    setLocationRelativeTo(null); // Center the window
    setVisible(true);

    }

    public void clickNameListener(JLabel label){
        label.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    label.setBackground(Color.BLUE);
                    label.setForeground(Color.white);
                    if(FirstClickName == null){
                        FirstClickName = label.getText();
                    }else{
                        SecondClickName = label.getText();
                    }
                
                }
            });
        
    }
    public void addBadListener(JLabel label){
          label.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    if (doYouHaveTwoNames()){
                    doNotSeatTogether.add(new String[]{FirstClickName, SecondClickName});
                     unHighlightNames();
                    lastListAddedTo = "good";
                    }

                }
            });

    }
       public void addGoodListener(JLabel label){
          label.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    if (doYouHaveTwoNames()){
                    seatTogether.add(new String[] {FirstClickName, SecondClickName});
                     unHighlightNames();
                    lastListAddedTo = "bad";
                        unHighlightNames();
                    }


                }
            });

    }

    public void addRemoveListener(JLabel label){
               label.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    if (lastListAddedTo.equals("good")){
                    seatTogether.removeLast();
                    unHighlightNames();
                    }else{
                     doNotSeatTogether.removeLast();
                      unHighlightNames();
                    }

                }
            });

    }
        

    public void addFinishListener(JLabel label){
         label.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    System.out.println("Your rule lists are set as follows");

                    System.out.println("Good together: ");
                    for (String[] student : seatTogether) {
                        System.out.print(student[0] + " & " + student[1] + "; ");
                    }
                    System.out.println("Bad together: ");
                    for (String[] student : doNotSeatTogether) {
                        System.out.print(student[0] + " & " + student[1] + "; ");
                    }

                    // System.out.println("Do you wish to continue y/n ?");
                    // Scanner sc2 = new Scanner(System.in);
                    // if (sc2.next().equals("y")){
                        dispose(); // this is all that is needed here!
                     App.randomise();
                        
                //     }else{
                //    RuleChoiceComplete = true;
                //    System.out.println("continue with your selection");
                //     }

                }
            });
        
    }

    public boolean doYouHaveTwoNames(){
        if(SecondClickName != null && FirstClickName != null){
            return true;
        }else{
            System.out.println("You must first select two names");
                return false;
            
        }
    }
    
    public void unHighlightNames(){
      
        for(JLabel lab:labelList){
            FirstClickName = null;
            SecondClickName = null;
            lab.setBackground(Color.white);
            lab.setForeground(Color.black);
        }
    }
}