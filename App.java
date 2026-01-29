import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App{
    public static ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Bob", "Charlie", "Suzie", "Alpha", "Bravo", "Delta", "Echo", "Foxtrot"));
    private static Integer classHeight = null;
    private static Integer classWidth = null;
    // private ArrayList<String><String>nameList



   
    public static void main(String [] args){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("We are going to create the grid size for your classroom");
        System.out.println("How Many Squares Height?");
        classHeight = sc1.nextInt();
        System.out.println("How Many Squares Width?");
        classWidth = sc1.nextInt();
        new ClassroomGrid(classHeight, classWidth);
        System.out.println("click to clour in the desk spaces");
        System.out.println("type 'done' after you are finished");
        String dun = sc1.next(); 
        while(!dun.equals("done")){
            System.out.println("are you done? - type 'done'");
            dun = sc1.next(); 
        }
        System.out.println("You have selected spaces" + ClassroomGrid.seatPlacements.toString());

     new RuleChoiceGrid(nameList);
       
         options();

    }

    public static void options(){

        Scanner sc3 = new Scanner(System.in);
        Integer num = null;

        try{
            while(num != 1 && num != 2 && num !=3){
                System.out.println("Now we have set up the classroom what would you like to do?");
                System.out.println("1 = Randomise Class");
                System.out.println("2 = Move Students");
                 num = sc3.nextInt();
            }
        if(num == 1){
            randomise();
        }
    }catch(Exception e){
        System.err.println();
    }

    }

    public static void randomise(){
        //if more names than desks we have an issue!
        int numberOfStudents = nameList.size();
        ArrayList<Integer> listOfNums  = new ArrayList<>();
        Integer[] orderStudentsAdded = new Integer[numberOfStudents];
        for(int i = 0; i< numberOfStudents ; i++){
            listOfNums.add(i); 
        }

       
        for(int i = 0; i< orderStudentsAdded.length; i++){
            Random rand = new Random();
            int randIndex = rand.nextInt(listOfNums.size());
             orderStudentsAdded[i] = listOfNums.get(randIndex); // add the number at the random place
             listOfNums.remove(randIndex); //remove the random place
        
        }

        // 1 2 3 4 5 6 7 
        System.out.println("sanity check what is the random order students will be added(should be no double ups)" + Arrays.toString(orderStudentsAdded));
        
        String [] orderedNameList = new String[numberOfStudents];
            for(int i = 0; i<numberOfStudents; i++){
                orderedNameList[i]= nameList.get(orderStudentsAdded[i]);
            }

            new ClassroomDisplay(classHeight,classWidth, orderedNameList, ClassroomGrid.seatPlacements);

    }

    // public static boolean canSitTogether(){

    // }


}