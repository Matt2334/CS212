/**
 * The Date212 class represents a date in the format of YYYYMMDD.
 * It provides methods to retrieve the year, month, day, and check for validity.
 * Implements Comparable to allow comparisons between Date212 objects through Collections.sort().
 */
public class Date212 implements Comparable<Date212>{
    public static IllegalDate212Exception IllegalDate212Exception;
    private
        int year, month, day;
        String x;
        boolean valid;
      
    /**
     * Constructs a Date212 object using a string.
     * It initializes the year, month, day, and checks for validity upon creation.
     *
     * @param x The string representation of the raw date 
     * @throws IllegalDate212Exception If an illegal date is encountered during initialization
     */ 
    //This is a contructor. It takes in the date in its original form and uses the methods declared below 
    // to assign the year, month, and day variables upon creation of a new Date212 object 
    public Date212(String x){ 
        this.x=x;
        year=setYear(); //sets the variable year to the proper year through the setYear method created below
        month=setMonth();
        day=setDay();
        if(!isValid()){
            throw new IllegalDate212Exception("Illegal Date Found");
        }
        valid=isValid();
        
    }

    // These five methods return the values of the variables. 
    // It allows the values to be viewed from the outside
    public boolean getValid(){return valid;}
    public int getX(){return Integer.parseInt(x);} //this returns the string x as an interger, thereby allowing it to be used in comparisons.
    public int getYear() {return year;}
    public int getMonth() {return month;}
    public int getDay(){return day;}

    //this sets the year by taking a substring of the first 4 characters in the string under variable x.  
    private int setYear(){ 
        return Integer.parseInt(x.substring(0, 4));
    }
    
    // this sets takes a substring of month from the date and converts into an integer
    private int setMonth(){
        return Integer.parseInt(x.substring(4, 6));
    }
    
    //this set method takes a substring of the date, extracting only the day values. Then it converts them into type Integer
    private int setDay(){ 
        return Integer.parseInt(x.substring(6, 8));
    }
   
    private boolean isValid(){
        //If the value of month is not within 1-12 (jan-dec) or if the value of day is not between 1 and 31 
        //then it will print out the date and return false
        if(month>12 || month<1 || day<1 || day>31){ 
            System.out.println(x); //prints out the string if the month or day is invalid
            return false; //then this s will then return false
        }
        else return true; //otherwise this will return true meaning the month and day are valid
    }
    
    
    
    //This method will return a string consisting of the month, day, and year respectively. 
    // In order to do so we convert the variables into strings using the valueOf method of the String class 
    public String toString(){ 
        return ""+String.valueOf(month)+"/"+String.valueOf(day)+"/"+String.valueOf(year);
    }
    
    
    /**
     * Compares this Date212 object with another Date212 to sort the object utilizing Collections.sort().
     * Returns a negative integer, zero, or a positive integer if this object is less than, 
     * equal to, or greater than the specified object.
     *
     * @param other The Date212 object to be compared
     * @return A negative or positive interger, or a zero; corresponding to if this object is less than, 
     * equal to, or greater than the specified object
     */
    @Override
    public int compareTo(Date212 other){
        if(this.x!=other.x){
            return this.getX()-other.getX();
        }
        else{
            return this.getX();
        }
    }
}
