import javax.swing.*;
public class pe1q3{
    public static void main(String[] args){
        String input=JOptionPane.showInputDialog(null,"Enter something:");
        int total=0;
        for(int i=0;i<input.length();i++){
            if(Character.isDigit(input.charAt(i))) total++;
        }
        JOptionPane.showMessageDialog(null,"The total number of digits are: "+total);
    }
}
/* 
Write a Java program that will read a String using a JOptionPane, count the number of characters that are
digits, and display that number in another JOptionPane. This may make use of the method in the Character
wrapper class called isDigit().
 */