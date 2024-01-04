import javax.swing.*;
import java.awt.GridLayout;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * The DateGUI class creates the GUI using JFrame, JTextArea, JMenu, JMenuItem, JFileChooser.
 * It generates various GUI components including menus, menu items, and text areas.
*/
public class DateGUI {
    public static FileMenuHandler fileMenuHandler;
    
    //Creates protected variables under the classes JFrame, JTextArea, and JMenuBar, JMenu, JMenuItem. 
    //Allows for the objects to be accessed throughout the code.  
    protected 
        JFrame frame;
        JTextArea leftArea, rightArea;
        JMenuBar menuBar;
        JMenu jFileMenu, jQuitMenu;
        JMenuItem exit, openFile;
        String p;
    
        // Paramaterized constructor for the DateGUI class. Upon creation of the GUI, 
        // all of these will be called/created
        /**
         * Parameterized constructor for the DateGUI class.
         *
         * @param fileMenuHandler An instance of FileMenuHandler class.
         * 
         * Upon creation of the GUI, this constructor initializes the GUI components.
        */
        public DateGUI(FileMenuHandler fileMenuHandler){ 
        frame = new JFrame("Project 3"); //creates a new GUI
        menuBar=new JMenuBar(); //Creates a menu bar
        
        // Creates the FileMenu and openFile MenuItem. It then assigns an action listener
        // in order to get the file path from fileMenuHandler once the open file item is clicked.  
        jFileMenu=new JMenu("File");
        openFile = new JMenuItem("Open File");
        openFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent onclickEvent) { 
                p=fileMenuHandler.getP(new File("/Users/"));
            }
        });
        jFileMenu.add(openFile);
        menuBar.add(jFileMenu); 

        // Creates the quit menu and exit MenuItem. It then assigns an action listener
        // in order to quit the program once the exit item is clicked. 
        jQuitMenu=new JMenu("Quit");
        exit=new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent onclickEvent) { 
                System.exit(0);
            }
        });
        jQuitMenu.add(exit);
        menuBar.add(jQuitMenu);
        frame.setJMenuBar(menuBar);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize( 500,400); //sets the size of the gui
        frame.setLocation(170,200); //sets the location of where the gui will popup
        frame.setLayout(new GridLayout(1,2));//makes the gui into a grid with 1 row and 2 columns
        leftArea= new JTextArea();//creates the leftArea as an object of JTextArea

        frame.add(leftArea);//adds the leftArea to the gui frame
        rightArea= new JTextArea(); //creates the rightArea as an object of JTextArea
        frame.add(rightArea); //adds the rightArea to the gui frame
        frame.setVisible(true); //allows the Gui to be seen
    }

    /**
     * Adds the string s to the left text area of the GUI.
     *
     * @param s a date212 object converted to a string using the toString method of Date212
     */
    public void fillLeft(String s){//adds the text taken from the parameter to the text area
        leftArea.append(s+"\n");//adds the text taken from the parameter to the text area
    }

    /**
     * Adds the string s to the right text area of the GUI.
     *
     * @param s a date212 object converted to a string using the toString method of Date212
     */
    public void fillRight(String s){ //adds the text taken from the parameter to the text area
        rightArea.append(s+"\n"); //adds the text taken from the parameter to the text area
    }

    /**
     * Method to return the file path assigned to variable p to the main function
     * @return The file path of the selected file
     */
    public String getPathing(){
        // Returns the path generated and assigned to variable p
        return p;
    }
}
