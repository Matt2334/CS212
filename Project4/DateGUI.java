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
    public EditMenuHandler yearSelector;
    
    //Creates protected variables under the classes JFrame, JTextArea, and JMenuBar, JMenu, JMenuItem. 
    //Allows for the objects to be accessed throughout the code.  
    protected 
        JFrame frame;
        JTextArea leftArea, rightArea;
        JMenuBar menuBar;
        JMenu jFileMenu, Edit;
        JMenuItem quit, openFile, Search;
        String p;
    
        // Paramaterized constructor for the DateGUI class. Upon creation of the GUI, 
        // all of these will be called/created
        /**
         * Parameterized constructor for the DateGUI class.
         *
         * @param fileMenuHandler An instance of FileMenuHandler class used for file operations.
         *                        Handles events associated with opening and selecting files.
         * 
         * Upon creation of the GUI, this constructor initializes the GUI components.
        */
        public DateGUI(FileMenuHandler fileMenuHandler){ 
        frame = new JFrame("Project 4"); //creates a new GUI
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
        
        // Creates the quit menu item. It then assigns an action listener
        // in order to quit the program once the quit item is clicked. 
        quit=new JMenuItem("Quit");
        quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent onclickEvent){
                System.exit(0);
            }
        });
        jFileMenu.add(quit);
        menuBar.add(jFileMenu);
       
        // Creates the Edit menu, which contains the search menu item.
        // It then adds an actionListener of the EditMenuHandler class. 
        Edit = new JMenu("Edit");
        Search = new JMenuItem("Search");
        yearSelector = new EditMenuHandler();
        Search.addActionListener(yearSelector);
        Edit.add(Search);
        menuBar.add(Edit);
          
        // Adds the menuBar with all its items to the gui "frame"
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
     * Notifies the user if the selected year is not found
     */
    public void dateNotThere(){
        leftArea.append("The year is not present in the file");
    }
    
    /**
     * Notifies the user if the file is selected before choosing a year to filter by
     */
    public void dateNotProvided(){
        leftArea.append("  Please re-run the program,\n  and enter a filter date\n  before selecting the file");
    }

    /**
     * Method to return the file path assigned to variable p to the main function
     * @return The file path of the selected file
     */
    public String getPathing(){
        // Returns the path generated and assigned to variable p
        return p;
    }

    /**
     * Method to return the desired filter year to the main function
     * @return The selected year to filter the file by
     */
    public int getFilterYear(){
        return yearSelector.getFilterYear();
    }
}
