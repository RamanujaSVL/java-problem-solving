package practice;

import java.util.*;
import java.util.stream.Collectors;

public class StringManipulationPrograms {

    enum StringOperations{
        Palindrome, ReverseString, RemoveAllDuplicateCharacters,
        FrequencyOfAllCharacters
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

    //TODO - CHECK FOR BETTER WAYS
    private void removeDuplicateCharacters(String str){
        List<Character> charsList = new ArrayList<>();

        for(int i=0;i<str.length();i++) {
            if(!charsList.contains(str.charAt(i)))
                charsList.add(str.charAt(i));
        }
        System.out.println(charsList.stream().map(Object::toString).collect(Collectors.joining()));

    }

    private void frequencyOfEachCharacter(String str){
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for(int i=0;i<str.length();i++){
            Character curr = str.charAt(i);

            /*
             * Using Lambda Expressions
             * frequencyMap.computeIfPresent(curr, (key, value) -> value + 1);
             * frequencyMap.computeIfAbsent(curr, key -> 1);
             */

            if(frequencyMap.containsKey(curr)){
                frequencyMap.put(curr, frequencyMap.get(curr)+1);
            } else {
                frequencyMap.put(curr,1);
            }
        }
        System.out.println(frequencyMap);
    }

    public static void main(String[] args) {

        StringManipulationPrograms program = new StringManipulationPrograms();

        int counter = 0;
        StringOperations[] operations = StringOperations.values();
        Map<Integer, StringOperations> operationsMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select From the Below Operations");

        for(StringOperations operation : operations){
            System.out.println(++counter+". "+ operation.name());
            operationsMap.put(counter, operation);
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
            case RemoveAllDuplicateCharacters:
                program.removeDuplicateCharacters(str);
                break;
            case FrequencyOfAllCharacters:
                program.frequencyOfEachCharacter(str);
                break;
        }
    }
}
