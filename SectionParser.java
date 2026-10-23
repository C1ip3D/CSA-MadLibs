public class SectionParser {
    /**
      Extracts and returns the substring from the current starting position up to (but not including) the opening tag index ('<').
      story - The full or remaining Mad Lib story string.
      tagStart - The index of the opening bracket '<' of the tag.
      Returns: The plain text string that appears before the tag.
     */
    // Fixed by Person 5: signature was getSection(String story, int tagStart) and always started at index 0.
    // The README signature is getSection(String story, int from, int tagStart), so "from" was added and the
    // substring now starts at from. Before, every call re-copied the story from the beginning, doubling text.
    // Requirement: algorithm to parse for sections of the Mad Lib to include
    public static String getSection(String story, int from, int tagStart) {
        // Use substring(startIndex, endIndex)
        // Extract text from index 0 up to tagStart (exclusive)
        // Fixed by Person 5: was story.substring(0, tagStart), now starts at from instead of 0
        return story.substring(from, tagStart);
    }

    /*
      Extracts and returns the rest of the story after the closing tag index ('>').
      story - The story string.
      tagEnd - The index of the closing bracket '>' of the tag.
      Returns: The remaining portion of the story after the tag.
    */  
    // Fixed by Person 5: signature was getRemainder(String story, int tagEnd) and added 1 to skip the >.
    // The README signature is getRemainder(String story, int from), where from is already the index right
    // after the last '>' (Person 1's loop sets from = tagEnd + 1). Adding 1 again would drop a character.
    // Requirement: algorithm to parse for sections of the Mad Lib to include
    public static String getRemainder(String story, int from) {
        // Ensure tagEnd is within bounds before taking the substring after '>'
        // Fixed by Person 5: was tagEnd + 1 <= story.length(), now checks from since from already skips the >
        if (from <= story.length()) {
            // substring(beginIndex) extracts from tagEnd + 1 to the end of the string
            // Fixed by Person 5: was story.substring(tagEnd + 1), now story.substring(from)
            return story.substring(from);
        }
        return "";
    }
}