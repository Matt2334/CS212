public class practice7{
    public static void main(String[] args){
        int myArray1[][]={
            {1, 3, 3, 2},
            {4,2,5,6},
            {1,2,3,4},
            {7,8,9,4}};
        System.out.println(diagonalEqualsRow(myArray1, 6));
    }
    public static boolean diagonalEqualsRow ( int [][] myArray, int row){
        if(myArray.length!=myArray[0].length) throw new IllegalArgumentException("Not a square matrix");
        else if(row>=myArray.length) throw new IllegalArgumentException("Illegal Row");
        else{
            int ds=0;
            int rs=0;
            for(int i=0;i<myArray.length;i++){
                ds+=myArray[i][i];
            }
            for(int i=0;i<myArray[row].length;i++){
                rs+=myArray[row][i];
            }
            return ds==rs;
        }
        
    }
}
