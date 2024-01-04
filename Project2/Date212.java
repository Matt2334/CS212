

public class Date212{
    private
        int year, month, day;
        String x;
        boolean valid;
    
    //This is a contructor. It takes in the date in its original form and uses the methods declared below 
    // to assign the year, month, and day variables upon creation of a new Date212 object    
    public Date212(String x){ 
        this.x=x;
        year=setYear(); //sets the variable year to the proper year through the setYear method created below
        month=setMonth();
        day=setDay();
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
    
    public boolean compareTo(Date212 other){ //this method takes in a different Date212 object and compares it with this one.  
        return this.getX()<other.getX(); //this will return true if this Date212 object is less than the other Date212 object
    }
}