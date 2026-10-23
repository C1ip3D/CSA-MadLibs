import java.util.Scanner;

/*
 * Project 1.2.10 Mad Libs
 * Purpose: Fills in Mad Lib stories with words the user types in.
 * Person 1 (this file) holds main and buildStory and calls the methods
 * written by Person 2 (TagParser), Person 3 (SectionParser) and
 * Person 4 (InputHelper).
 */
public class MadLibs
{
    public static void main(String[] args)
    {
        // Requirement: one Scanner, created in main and passed to promptUser
        Scanner in = new Scanner(System.in);

        // Requirement: variables containing the incomplete Mad Libs
        String story1 = "The <noun> <verb> across the <adjective> pond";
        String story2 = "I went to the zoo to see a <noun>. There were people <verb> "
                      + "around the enclosure which made the <adjective> apes go bananas.";
        // Original story (Person 1 writes this): at least 7 blanks
        String story3 = "On a <adjective> Saturday, my <noun> and I decided to <verb> "
                      + "to the <noun>. We brought <number> <plural noun> and a very "
                      + "<adjective> sandwich. By noon we were <verb> so hard that a "
                      + "<noun> asked us to leave.";

        runStory(in, "Test 1: The Pond", story1);
        runStory(in, "Test 2: The Zoo", story2);
        runStory(in, "Test 3: Our Original Mad Lib", story3);

        System.out.println("Thanks for playing Mad Libs!");
        in.close();
    }

    // Prints the intro and the original story, collects answers, then prints the result
    public static void runStory(Scanner in, String title, String story)
    {
        System.out.println("==============================");
        System.out.println(title);
        System.out.println("Fill in the blanks to complete this story:");
        System.out.println(story);
        System.out.println();

        String completed = buildStory(in, story);

        // Requirement: final print statement showing the completed story
        System.out.println();
        System.out.println("Here is your completed Mad Lib:");
        System.out.println(completed);
        System.out.println();
    }

    /*
     * Requirement: story generation function
     * Algorithm: find the next '<', add the plain text before it (P3),
     * read the part of speech inside <...> (P2), ask the user for a word (P4),
     * add the answer, then repeat from just after the '>'. When no tags are
     * left, add the rest of the story (P3) and return it.
     */
    public static String buildStory(Scanner in, String story)
    {
        String result = "";
        int pos = 0;
        int tagStart = TagParser.findTagStart(story, pos);

        while (tagStart != -1)
        {
            int tagEnd = TagParser.findTagEnd(story, tagStart);
            if (tagEnd == -1)
            {
                break; // a '<' with no matching '>' is treated as plain text
            }

            result += SectionParser.getSection(story, pos, tagStart);
            String partOfSpeech = TagParser.getPartOfSpeech(story, tagStart, tagEnd);
            result += PromptUser.promptUser(in, partOfSpeech);

            pos = tagEnd + 1;
            tagStart = TagParser.findTagStart(story, pos);
        }

        result += SectionParser.getRemainder(story, pos);
        return result;
    }
}



