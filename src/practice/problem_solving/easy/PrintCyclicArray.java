package practice.problem_solving.easy;

public class PrintCyclicArray {

    void printCyclicArray(int [] arrayOfIntegers, int rows, int columns) {
        int arrayIndex = 0;
        for(int i=0;i<rows; i++) {
            for(int j=0;j<columns; j++, arrayIndex++) {
                if(arrayIndex > columns)
                    arrayIndex = 0;
                if( j < columns-1)
                    System.out.print(arrayOfIntegers[arrayIndex]+", ");
                else
                    System.out.print(arrayOfIntegers[arrayIndex]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new PrintCyclicArray().printCyclicArray(new int[]{1,2,3,4,5}, 3,4);
    }
}
