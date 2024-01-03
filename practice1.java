import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
// import javax.swing.JOptionPane;
public class practice1 {
    public static void main(String[] args){
        // String s=JOptionPane.showInputDialog(null, "Enter a whatever you want printed on screen: ");
        // System.out.print(Character.toUpperCase(s.charAt(3)));
        JFrame frame=new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocation(200,300);
        frame.setVisible(true);
        JTextArea n=new JTextArea();
        frame.add(n);
        try{
            Scanner scan= new Scanner(new File("integers.txt"));
            String in = scan.nextLine();
            while(scan.hasNextLine())
            {
                n.append(in+"\n");
                in=scan.nextLine();
            }
            scan.close();
        }
        catch (FileNotFoundException e){e.printStackTrace();}
        // n.append(s);
        
    }
}





// import java.util.*;
// import java.io.File;
// import java.io.FileNotFoundException;
// public class practice1{
//     public static void main(String[] args){
//         try{
//         Scanner in=new Scanner(new File("integers.txt"));
//         String li=in.nextLine();
//         int lengthfilled=0;
//         short[] myArray=new short[10];
//         while(in.hasNextLine()&&lengthfilled<myArray.length){
//             myArray[lengthfilled]=Short.parseShort(li);
//             System.out.print(myArray[lengthfilled]);
//             lengthfilled++;
//             li=in.nextLine();
//         }    
//         }
//         catch (FileNotFoundException e){e.printStackTrace();}
//     }
// }