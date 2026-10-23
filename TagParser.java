public class TagParser
{
    /*
     Returns where the next '<' is at or after from, or -1 if there are no tags left
     indexOf(String) always searches from the start, so we cut the story at
     from first, search that part, then add from back to get the real
     position in the full story
     */
    // Requirement: algorithm to parse for the parts of speech to replace
    public static int findTagStart(String story, int from)
    {
        if (from < 0 || from > story.length())
        {
            return -1; // from is outside the story so there's nothing to search
        }
        int startInPiece = story.substring(from).indexOf("<");
        if (startInPiece == -1)
        {
            return -1; // no more '<' so no tags left
        }
        return from + startInPiece;
    }

    /*
     Returns where the next '>' is at or after from, or -1 if there isn't one
     Works the same way as findTagStart but looks for '>' instead
     Person 1 passes in tagStart as from so it finds the '>' that closes that tag
     */
    // Requirement: algorithm to parse for the parts of speech to replace
    public static int findTagEnd(String story, int from)
    {
        if (from < 0 || from > story.length())
        {
            return -1; // from is outside the story so there's nothing to search
        }
        int endInPiece = story.substring(from).indexOf(">");
        if (endInPiece == -1)
        {
            return -1; // found '<' but it never closes
        }
        return from + endInPiece;
    }

    /*
     Returns the part of speech between '<' (at start) and '>' (at end),
     or "" if either bracket wasn't found
     The +1 skips the '<' and substring stops right before the '>'
     Spaces stay in so multi word tags like <plural noun> still work
     */
    // Requirement: algorithm to parse for the parts of speech to replace
    public static String getPartOfSpeech(String story, int start, int end)
    {
        if (start == -1 || end == -1)
        {
            return ""; // no complete tag so nothing to return
        }
        return story.substring(start + 1, end);
    }

    /*
     Test to make sure it goes through every tag in order
     The story never gets cut, instead from moves to right after each '>'
     so the next search starts past the tag we already used
     */
    public static void main(String[] args)
    {
        String story = "I went to the animal <noun>; the <plural noun> and the <number> beasts were there.";
        int from = 0;
        boolean moreTags = true;

        while (moreTags)
        {
            int tagStart = findTagStart(story, from);
            int tagEnd = findTagEnd(story, tagStart);
            if (tagEnd == -1)
            {
                moreTags = false; // no complete tags left so stop
            }
            else
            {
                System.out.println(getPartOfSpeech(story, tagStart, tagEnd));
                from = tagEnd + 1; // move past the '>' so we find the next tag
            }
        }
    }
}