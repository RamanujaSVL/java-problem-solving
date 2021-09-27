package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringManipulationPrograms {

    enum StringOperations{
        Palindrome, ReverseString
    }

    private String reverseString(String str){
        char [] strArray = new char[str.length()];
        char [] originalStrArray = str.toCharArray();
        for(int i = strArray.length - 1, j=0; i >= 0 && j < str.length(); i--, j++){
            strArray[j] = originalStrArray[i];
        }

        System.out.println("Reversed String - "+new String(strArray));

        return new String(strArray);
    }

    private void checkPalindrome(String str) {
        try {
            boolean stringLengthEven = str.length() % 2 == 0;
            int stringLength = str.length();
            int medianLength = stringLength / 2;

            if(stringLengthEven){
                System.out.println("Is Palindrome - "+str.substring(0, medianLength).equals(reverseString(str.substring(medianLength))));
            } else {
                System.out.println("Is Palindrome - "+str.substring(0, medianLength+1).equals(reverseString(str.substring(medianLength))));
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {

        StringManipulationPrograms program = new StringManipulationPrograms();

        int counter = 0;
        StringOperations opers[] = StringOperations.values();
        Map<Integer, StringOperations> operationsMap = new HashMap<Integer, StringOperations>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select From the Below Operations");

        for(StringOperations oper : opers){
            System.out.println(++counter+". "+oper.name());
            operationsMap.put(counter, oper);
        }

        int chosenOperation = scanner.nextInt();

        System.out.println("Enter a String");
        String str = scanner.next();

        switch(operationsMap.get(chosenOperation)){
            case Palindrome:
                program.checkPalindrome(str);
                break;
            case ReverseString:
                program.reverseString(str);
                break;
        }
    }
}
