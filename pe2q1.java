import javax.swing.*;
public class pe2q1{
    public static void main(String[] args){
        String input=JOptionPane.showInputDialog(null,"Input String: ");
        int count=0;
        for(int i=0;i<input.length()-1;i++){
            if(Character.isDigit(input.charAt(i)) && Character.isDigit(input.charAt(i+1))) 
            {
                count++;
            }
        }
        if(count!=1)
            JOptionPane.showMessageDialog(null,"Two digits happen "+count+" times.");
        else
            JOptionPane.showMessageDialog(null, "Two digits happen "+count+" time.");
    }
}
