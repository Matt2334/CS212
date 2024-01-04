import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 * ActionListener implementation to handle edit menu actions and retrieve a filter year.
 */
public class EditMenuHandler implements ActionListener{
    protected  
        String filter_year;
    /** 
     * Default EditMenuHandler class constructor 
     */
    public EditMenuHandler(){}

    /**
     * When the action occurs it will prompt the user to select a filter year.
     * @param e The ActionEvent triggering the action.
     */
    public void actionPerformed(ActionEvent e){
        // prompts the user to input a year to filter by utilizing a JOptionPane window
        filter_year = JOptionPane.showInputDialog("Enter a year: ");
    }

    /**
     * This will return the filter_year if it is not null.
     * Otherwise it will return 0;
     * @return filter_year the year to filter dates by
     */
    public int getFilterYear(){
        if(filter_year!=null){
            // returns the filter_year which is converted from a string to an int
            return Integer.parseInt(filter_year);
        }
        else{
            return 0;
        }
    }

}

