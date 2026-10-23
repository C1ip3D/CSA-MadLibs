import java.util.Scanner;
// Bugtested by Person 5
/* Fixed by Person 5: class was named promptUser (lowercase). Class names should be capitalized,
  so it was renamed to PromptUser and the file was renamed to PromptUser.java to match. */
public class PromptUser {
    //callable function, takes partof speech and scanner as parameters, returns a string
    //part of speech could be noun, verb, adjective, adverb, etc. Scanner is used to get user input
    // Fixed by Person 5: parameters were in the wrong order (String, Scanner) and the Scanner was named "input".
    // Changed to (Scanner in, String partOfSpeech) so Person 1 call compiles
    // Requirement: algorithm that processes user input
    public static String promptUser(Scanner in, String partOfSpeech) {
        
        /* check first letter, if vowel it will not return -1 and will do an, 
        if its not a vowel it will return -1 and will do a*/
        // Requirement: various prompts to keep the user on track
        String vowels = "aeiouAEIOU";
        String firstLetter = partOfSpeech.substring(0, 1);
        //it will ask for the response word that matches part of speech
        if (vowels.indexOf(firstLetter) == -1) {
            System.out.println("Enter a " + partOfSpeech + ":");
        } else {
            System.out.println("Enter an " + partOfSpeech + ":");
        }
        /*takes the user input and returns it as a string, which is an answer to the prompt of giving a noun,etc
        takes input then moves to next Scanner line so input will always start on new blank line*/
        // Fixed by Person 5: was input.nextLine(), renamed to in.nextLine() to match new parameter name
        // Requirement: algorithm that processes user input
        String word = in.nextLine();
        
        //returns the user input as a string in the end to be used in the madlib
        return word;
    }
}