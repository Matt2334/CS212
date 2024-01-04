
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.GridLayout;
public class DateGUI {
    private //creates private variables under the classes JFrame, JTextArea, and JTextArea respecitively. Allows for the objects to be accessed throughout the code.  
        JFrame frame;
        JTextArea leftArea;
        JTextArea rightArea;
    
        public DateGUI(){ //Contructor for the DateGUI class. It will call these upon creation of the obect
        frame = new JFrame("Project 2"); //creates a new GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize( 400,300); //sets the size of the gui
        frame.setLocation(170,200); //sets the location of where the gui will popup
        frame.setLayout(new GridLayout(1,2));//makes the gui into a grid with 1 row and 2 columns
        leftArea= new JTextArea();//creates the leftArea as an object of JTextArea
        frame.add(leftArea);//adds the leftArea to the gui frame
        rightArea= new JTextArea(); //creates the rightArea as an object of JTextArea
        frame.add(rightArea); //adds the rightArea to the gui frame
        frame.setVisible(true); //allows the Gui to be seen
        
    }
    public void fillLeft(String s){//adds the text taken from the parameter to the text area
        leftArea.append(s+"\n");//adds the text taken from the parameter to the text area
    }
    public void fillRight(String s){ //adds the text taken from the parameter to the text area
        rightArea.append(s+"\n"); //adds the text taken from the parameter to the text area
    }
}
