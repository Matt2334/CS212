import java.lang.IllegalArgumentException;
/**
 * The class creates a new exception extending the IllegalArgumentException 
 */
public class IllegalDate212Exception extends IllegalArgumentException{
    /**
     * Non-default constructor that passes a message to the parent class
     * @param message
     */
    public IllegalDate212Exception(String message){
        // takes in the parameter message and returns it to the IllegalArgumentException
        // class using the super
        super (message);
    }
}