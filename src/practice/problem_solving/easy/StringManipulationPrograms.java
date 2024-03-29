package practice.problem_solving.easy;

import java.util.*;
import java.util.stream.Collectors;

public class StringManipulationPrograms {

    enum StringOperations{
        Palindrome, ReverseString, RemoveAllDuplicateCharacters,
        FrequencyOfAllCharacters, Anagrams, CharacterWithHighestFrequency
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

    private void areStringAnagrams(String str1, String str2) {
        boolean flag = false;
        if(str1.length() != str2.length()){
            flag = false;
        }
        else {
            int[] charRange = new int[256];
            for(int i=0; i<str1.length(); i++){
                charRange[str1.charAt(i)]++;
                charRange[str2.charAt(i)]--;
            }

            for(int i=0; i<charRange.length; i++){
                if(charRange[i] != 0) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
        }
        if(!flag)
            System.out.println("Not Anagrams");
        else
            System.out.println("Anagrams");
    }

    /*
    * Date : 31-10-2021
    * Approach 1 : Taking an Array of integers with ASCII Character range of 256
    *              and incrementing the respective ASCII character representation
    *              and returning the index of the integer with highest count, which is the
    *              character with highest frequency, when casted as a char.
    *
    * Approach 2 : Having a HashMap similar to FrequencyOfAllCharacters and returning the
    *              value of the key with highest value.
     */
    private static void characterWithHighestFrequency(String str){

        int[] charRange = new int[256];

        for(int i = 0; i < str.length(); i++){
            charRange[str.charAt(i)]++;
        }

        List<Integer> listOfInteger = Arrays.stream(charRange)
                                            .boxed()
                                            .collect(Collectors.toList());

        System.out.println((char)listOfInteger.indexOf(Collections.max(listOfInteger)));
    }

    private static String readString(Scanner sc) {
        return sc.next();
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

        System.out.println("Enter a word or multiple words with a , delimiter and no spaces");

        switch(operationsMap.get(chosenOperation)){
            case Palindrome:
                program.checkPalindrome(readString(scanner));
                break;
            case ReverseString:
                program.reverseString(readString(scanner));
                break;
            case RemoveAllDuplicateCharacters:
                program.removeDuplicateCharacters(readString(scanner));
                break;
            case FrequencyOfAllCharacters:
                program.frequencyOfEachCharacter(readString(scanner));
                break;
            case Anagrams:
                //TODO - For Reading more than one word with existing approach - could be better
                String[] twoWords = readString(scanner).split(",");

                String str1 = twoWords[0].toLowerCase();
                String str2 = twoWords[1].toLowerCase();

                program.areStringAnagrams(str1, str2);
                break;
            case CharacterWithHighestFrequency:
                characterWithHighestFrequency(readString(scanner));
                break;
        }
    }
}
